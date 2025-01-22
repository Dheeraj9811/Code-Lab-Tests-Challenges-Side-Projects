import heapq
import math

def reduce_array(arr):
    min_heap = []
    max_heap = []

    for num in arr:
        heapq.heappush(min_heap, num)
        heapq.heappush(max_heap, -num)

    total_cost = 0
    n = len(arr)
    count = 0
    while count < n - 1:
        min_val = heapq.heappop(min_heap)
        max_val = -heapq.heappop(max_heap)

        cost = math.ceil((min_val + max_val) / (max_val - min_val + 1))
        total_cost += cost

        if min_heap:
            heapq.heappush(min_heap, min_val + max_val)
            heapq.heappush(max_heap, -(min_val + max_val))

        count += 1

    return total_cost

arr = [3, 5, 2, 1, 9, 6]
print("Total cost:", reduce_array(arr))
