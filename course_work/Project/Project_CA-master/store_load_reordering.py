import threading
import time
import random

# Register template
class Register:
    def __init__(self, name, value):
        self.name = name
        self.value = value
    def __str__(self):
        return f'{self.name} = {self.value}'


# main_memory: address to value mapping
main_memory = {
    'X' : 0,
    'Y' : 0
}

# register file: name to register mapping
register = {f'R{i}': Register(f'R{i}', 0) for i in range(16)}


'''
Program executed by Core C1
'''
def core_c1():
    # store operation: S1 
    main_memory['X'] = 100
    
    # store operation: S2
    register['R1'].value = 1
    
    # Load operation: L1
    def load_l1():
        time.sleep(random.random() ** 10)
        register['R3'].value = main_memory['X']
    
    # Create threads for Load operations L1
    thread_l1 = threading.Thread(target=load_l1)    
    thread_l1.start()

    # Load operation: L2
    register['R3'].value = register['R3'].value + 100
    
    # Load operation: L6 
    register['R5'].value = register['R2'].value

    # Branch operation: B2
    while register['R5'].value != 1:
        register['R5'].value = register['R2'].value
    
    # Load operation: L7
    register['R11'].value = main_memory['Y']
    
    # Wait for thread to finish
    thread_l1.join()

'''
Program executed by Core C2
'''
def core_c2():
    # store operation: S3
    main_memory['Y'] = 150   
    
    # store operation: S4    
    register['R2'].value = 1
    
    # Load operation: L3
    register['R4'].value = register['R1'].value
    
    # Branch operation: B1
    while register['R4'].value != 1:
        register['R4'].value = register['R1'].value

    # Load operation: L4 
    register['R10'].value = main_memory['X']
    
    # Load operation: L5
    register['R10'].value = register['R10'].value * 200



# Create threads for Core C1 and Core C2
thread1 = threading.Thread(target=core_c1)
thread2 = threading.Thread(target=core_c2)

# Start both threads
thread1.start()
thread2.start()

# Wait for both threads to finish
thread1.join()
thread2.join()

print("************************ Done Executing all cores ************************")
print("************************ Content of Register File ************************")
for reg in register.values():
    print(reg)
print("************************ Content of Main Memory ************************")
for addr, value in main_memory.items():
    print(f'{addr} = {value}')

print('\nResult: ')
if register['R3'].value != 200:
    print('Load-Store Reordering is detected between L1 and S1')
    print('Execution order: L1 -> S1 -> S2 -> L2')
else:
    print('Load-Store Reordering is not detected between L1 and S1')
    print('Execution order: S1 -> S2 -> L1 -> L2')