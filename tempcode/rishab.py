# make array of coins 
coins = [1, 2, 5]
# make combinations of coins use in building fn combinations
import itertools
com_set = itertools.combinations(coins,2)
# print
for i in com_set:
    print(i)