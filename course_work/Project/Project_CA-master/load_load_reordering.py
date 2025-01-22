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
    
    def load_Register_from_Register(registerName, registerLoadFrom, offset, core, statement):
        time.sleep(random.random() * 0.1)
        print(f'core{core} statement {statement}')
        register[registerName].value = register[registerLoadFrom].value + offset

    def load_Register_from_Memory(registerName, var, core, statement):
        time.sleep(random.random() * 0.1)
        print(f'core{core} statement {statement}')
        register[registerName].value = var

    # store operation: S1
    main_memory['X'] = 100
    # store operation: S2
    register['R1'].value = 1
    
    # Load operation: L1
    thread_1 = threading.Thread(target=load_Register_from_Memory,args=('R3', main_memory['X'], 1, 'L1'))

    # Load operation: L2
    thread_2 = threading.Thread(target=load_Register_from_Register,args=('R3', 'R3', 100, 1, 'L2'))
    
    thread_1.start()
    thread_2.start()
    
    thread_1.join()
    thread_2.join()

    # Load operation: L6
    load_Register_from_Register('R5', 'R2', 0, 1, 'L6')
    
    # Branch operation: B2
    while register['R5'].value != 1:
        load_Register_from_Register('R5', 'R2', 0, 1, 'L6')
    
    # Load operation: L7
    load_Register_from_Memory('R11', main_memory['Y'], 1, 'L7')



'''
Program executed by Core C2
'''
def core_c2():
    
    def load_Register_from_Register(registerName, registerLoadFrom, offset, core, statement):
        time.sleep(random.random() * 0.1)
        print(f'core{core} statement {statement}')
        register[registerName].value = register[registerLoadFrom].value + offset

    def load_Register_from_Register_Multiplication(registerName, registerLoadFrom, factor, core, statement):
        time.sleep(random.random() * 0.1)
        print(f'core{core} statement {statement}')
        register[registerName].value = register[registerLoadFrom].value * factor

    def load_Register_from_Memory(registerName, var, core, statement):
        time.sleep(random.random() * 0.1)
        print(f'core{core} statement {statement}')
        register[registerName].value = var
    
    # store operation:S3
    main_memory['Y'] = 150

    # store operation: S4    
    register['R2'].value = 1
    
    # Load operation: L3
    load_Register_from_Register('R4', 'R1', 0, 2, 'L3')
    
    # Branch operation: B1
    while (register['R4'].value != 1):
        load_Register_from_Register('R4', 'R1', 0, 2, 'L3')

    # Load operation: L4
    thread_1 = threading.Thread(target=load_Register_from_Memory, args=('R10', main_memory['X'], 2, 'L4')) 

    # Load operation: L5
    thread_2 = threading.Thread(target=load_Register_from_Register_Multiplication,args=('R10', 'R10', 200, 2, 'L5')) 

    thread_1.start()
    thread_2.start()

    thread_1.join()
    thread_2.join()


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
    print('Load-Load Reordering is detected between L1 and L2')
else:
    print('Load-Load Reordering is not detected between L1 and L2')
if register['R10'].value != 20000:
    print('Load-Load Reordering is detected between L4 and L5')
else:
    print('Load-Load Reordering is not detected between L4 and L5')