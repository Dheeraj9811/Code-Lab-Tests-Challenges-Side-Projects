# Write a function solution that, given a string S consisting of N letters 'a' and/or 'b' returns True when all occurrences of letter 'a' are before all occurrences of letter 'b' and returns False otherwise.
def solution(s):
    # Check if the string contains only 'a' or 'b'
    if s.count('a') == len(s) or s.count('b') == len(s):
        return True
    # Check if the string contains both 'a' and 'b'
    elif s.count('a') > 0 and s.count('b') > 0:
        # Check if all occurrences of letter 'a' are before all occurrences of letter 'b'
        if s.index('b') > s.rindex('a'):
            return True
        else:
            return False
    else:
        return False




# Test the function with examples
print(solution("aabbb"))  # Output: True 
print(solution("ba"))  # Output: False
print(solution("aaa"))  # Output: True
print(solution("b"))  # Output: True
print(solution("abba"))  # Output: False

