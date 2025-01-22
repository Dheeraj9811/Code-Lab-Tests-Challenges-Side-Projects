#include <bits/stdc++.h>
using namespace std;
/*
689. Maximum Sum of 3 Non-Overlapping Subarrays
Attempted
Hard
Topics
Companies
Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

 

Example 1:

Input: nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Example 2:

Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] < 216
1 <= k <= floor(nums.length / 3)

*/

//  Brute force soln
/*
class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> ans(3);
        int max = 0;
        for(int i = 0;i<=n-(3*k);i++){
            //take k , if k is not possible skip
            // cout<<i<<" ";
            int a = dosum(nums,i,k);
            for(int j = i+k;j<=n-(2*k);j++){
                // cout<<j<<" ";
                int b = dosum(nums,j,k);

                for(int l = j+k;l<=n-(k);l++){
                    // cout<<k<<endl;
                        // cout<<i<<" "<<j<<" "<<l<<endl;
                    int c = dosum(nums,l,k);
                    if(a+b+c>max || (a+b+c == max && vector<int> {i , j ,l} < ans)){
                        max = a+b+c;
                        ans.erase(ans.begin(),ans.end());
                        ans.push_back(i); ans.push_back(j); ans.push_back(l);
                    }
                }
            }
            
        } 
        return ans;
    }

    int dosum(vector<int> & arr, int i, int k){
        int ans = 0;
        int max = i+k;
        for(i;i<arr.size() && i<max;i++){
            ans += arr[i];
        }
        return ans;
    }
};
*/ 

// index        0   1   2   3   4   5   6   7 
// arr,k  :    [1,  2,  1,  2,  6,  7,  5,  1]  , k = 2
// presum : [0, 1,  3,  4,  6,  12, 19, 24, 25]
//

class Solution {
public:
    vector<vector<int>> dp;
    vector<int> ans;
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        int n = nums.size(); 
        vector<int> presum(n+1,0);
        dp = vector<vector<int>>(n+1, vector<int>(4,-1));
        // ans = vector<int>(3,-1);
        // prefix sum calculation O(n)
        for(int i = 0;i<n;i++){
            presum[i+1] = presum[i] +nums[i];
        }
        solve(0,k,3,presum);
        return ans;    

    }

    int cal(int i ,int rem, int k,vector<int>&presum){
        if( rem ==0) return 0;
        if(i+k >=presum.size()) return INT_MIN;
        if(dp[i][rem] != -1) return dp[i][rem];
        int take = presum[i+k] - presum[i] + cal(i+k, rem-1,k,presum);
        int nt = cal(i+1,rem,k,presum);


        return dp[i][rem] = max(take , nt);
    }

    void solve(int i , int k,int rem, vector<int>& presum){
        if(rem == 0 || i+k > presum.size()-1 ) return; 

        int take = presum[i+k] - presum[i] + cal(i+k, rem-1,k,presum);
        int nt = cal(i+1,rem,k,presum);

        if(take >= nt){
            ans.push_back(i);
            solve(i+k,k,rem-1,presum);
        }
        else{
            solve(i+1,k,rem,presum);
        }

    }
};


/*



O(n)  soln using 3 pointer
class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
       int n = nums.size(); 
        vector<int> presum(n+1,0);

        // prefix sum calculation
        for(int i = 0;i<n;i++){
            presum[i+1] = presum[i] +nums[i];
        }

        //precal left side max sun index
        vector<int> ls(n,-1);
        int max = -1;
        for(int i = k;i<=presum.size()-k-1;i++){
            int curr = presum[i] - presum[i-k];
            if(curr > max){
                ls[i-k] = i-k;
                max = curr;
            }
            else{
                ls[i-k] = ls[i-1-k];
            }
        }

         // precal rightside max sum
        max = -1;
        vector<int> rs(n,-1); // TODO OPTIMIZE FOR SIZE
        for(int i = n;i>=k;i--){
            int curr = presum[i] - presum[i-k];
              if(curr >= max){
                rs[i-k] = i-k;
                max = curr;
            }
            else{
                rs[i-k] = rs[i-k+1];

            }
        }
         //  now finding the main answer
        max = -1;
        vector<int> ans(3,-1);
        for(int i =k;i<=n-2*k;i++){
            int mids = presum[i+k] - presum[i];
            int li = ls[i-k], ri = rs[i+k];
            int ls = presum[li+k] - presum[li] , rs = presum[ri+k] - presum[ri];
            int currsum = ls +rs+mids;
            if(currsum>max){
                ans[0] = li; ans[1] =  i ; ans[2] = ri;
                max = currsum;
            }
        }

        return ans;
    }
};
*/