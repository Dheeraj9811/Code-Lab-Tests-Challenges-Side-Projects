#include<bits/stdc++.h>
using namespace std;

/*
2342. Max Sum of a Pair With Equal Sum of Digits
Medium
Topics
Companies
Hint
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
*/

class Solution {
public:
    int maximumSum(vector<int>& nums) {
        unordered_map<int , priority_queue<int>> m;
        // tc n*9
        for(auto val : nums){
            m[sumOfDigits(val)].push(val);
        }

        int ans = -1;
        //tc n
        for(auto& val : m){
            if(val.second.size()>1){
                int f = val.second.top(); val.second.pop();
                int s = val.second.top(); val.second.pop();

                ans = max(ans,f+s);
            }
        }

        return ans;

    }
    // Tc MAX = O(9) means time time run
    int sumOfDigits(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n = n/10;
        }

        return sum; 
    }
};

// storing min heap inside vector of size 81
class Solution2 {
private:
    // Helper function to compute the sum of digits of a number
    int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

public:
    int maximumSum(vector<int>& nums) {
        // Vector to store a min heap for each possible digit sum (0 to 81)
        vector<priority_queue<int, vector<int>, greater<int>>> digitSumGroups(
            82);

        int maxPairSum = -1;

        // Group numbers by their digit sums, maintaining heap size of 2
        for (int number : nums) {
            int digitSum = calculateDigitSum(number);
            digitSumGroups[digitSum].push(number);

            // Keep only the top 2 largest numbers in the heap
            if (digitSumGroups[digitSum].size() > 2) {
                digitSumGroups[digitSum].pop();  // Remove the smallest element
            }
        }

        // Traverse the vector to find the maximum pair sum for each group
        for (auto& minHeap : digitSumGroups) {
            if (minHeap.size() == 2) {
                int first = minHeap.top();
                minHeap.pop();
                int second = minHeap.top();
                maxPairSum = max(maxPairSum, first + second);
            }
        }

        return maxPairSum;
    }
};


// simply stroing 2 values in vector<> 81 size ,  side by side comparing if vec[sum] >0 means already stored so ehck current + vec[sum] and store max in vec[sum] = max(num , vec[sum])
class Solution2 {
public:
    int maximumSum(vector<int>& nums) {
        int result = -1;
        // Array to map digit sums to the largest element with that sum
        // (82 to cover all possible sums from 0 to 81)
        int digitMapping[82] = {};

        for (int element : nums) {
            int digitSum = 0;

            // Calculate the digit sum of the current element
            for (int currValue = element; currValue; currValue /= 10) {
                int currDigit = currValue % 10;
                digitSum += currDigit;
            }

            // Check if there is already an element with the same digit sum
            if (digitMapping[digitSum] > 0) {
                // Update the result if the sum of the current and mapped
                // element is greater
                result = max(result, digitMapping[digitSum] + element);
            }

            // Update the mapping to store the larger of the current or previous
            // element for this digit sum
            digitMapping[digitSum] = max(digitMapping[digitSum], element);
        }

        return result;
    }
};