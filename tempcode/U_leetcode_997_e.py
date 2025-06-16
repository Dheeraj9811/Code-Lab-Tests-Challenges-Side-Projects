class Solution:
    
    def sortedSquares(self, nums: List[int]) -> List[int]:
        # using 2 pointer approch
        n = len(nums)
        ans = [0]*n
        i = 0
        j = n-1
        curr = n-1

        while(i<=j):
            if abs(nums[i]) > abs(nums[j]):
                ans[curr] = nums[i]**2
                i += 1
            else:
                ans[curr] = nums[j]**2
                j -= 1
            curr -= 1
        

        return ans

        