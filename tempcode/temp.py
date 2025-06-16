import bisect

def first_in_range(arr, min_val, max_val):
    idx = bisect.bisect_left(arr, min_val)
    print(f"Index found: {idx}")
    if idx < len(arr) and arr[idx] <= max_val:
        return arr[idx]
    return None

arr = [1]
min_val = 0
max_val = 0
result = first_in_range(arr, min_val, max_val)
if result is not None:
    print(f"First element in range [{min_val}, {max_val}] is: {result}")