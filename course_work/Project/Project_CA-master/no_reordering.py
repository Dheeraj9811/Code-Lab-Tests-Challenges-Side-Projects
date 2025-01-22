import threading

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
    # store operation: S1 and S2
    main_memory['X'] = 100
    register['R1'].value = 1
    
    # Load operation: L1  and L2
    register['R3'].value = main_memory['X']
    register['R3'].value = register['R3'].value + 100
    
    # Load operation: L6 and L7
    register['R5'].value = register['R2'].value
    while register['R5'].value != 1:
        register['R5'].value = register['R2'].value
    register['R11'].value = main_memory['Y']
    

'''
Program executed by Core C2
'''
def core_c2():
    # store operation: S3 and S4
    main_memory['Y'] = 150
    register['R2'].value = 1
    
    # Load operation: L3, L4 and L5
    register['R4'].value = register['R1'].value
    while register['R4'].value != 1:
        register['R4'].value = register['R1'].value
    register['R10'].value = main_memory['X']
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

print("************************ Done Executing all cores ************************\n")
print("************************ Register File ************************")
for reg in register.values():
    print(reg)
print("************************ Main Memory ************************")
for addr, value in main_memory.items():
    print(f'{addr} = {value}')