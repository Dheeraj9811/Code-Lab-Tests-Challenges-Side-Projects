# include <bits/stdc++.h>
using namespace std;





class Solution1 {
public:
    vector<int> minOperations(string b) {
        vector<int> one;
        vector<int> ans;
        int n = b.size();
        for(int i = 0;i<n;i++){
            if(b[i] == '1') one.emplace_back(i);
        }

        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int val : one){
                sum += abs(val-i);
            }
            ans.emplace_back(sum);
        }

        return ans;

    }
};

class Solution {
    public:
        vector<int> minOperations(string b) {
            int n = b.size();
            vector<int> ans(n);

            int count = 0;
            for(int i = 0;i<n;i++){
                ans[i] = count + (i == 0 ? 0 : ans[i-1]);
                if (b[i] == '1') count++;
            }
            count = 0; int sum = 0;
            for(int i =  n -1 ; i<=0;i--){
                ans[i] = count + sum;
                if(count > 0) sum++;
                if(b[i] == '1') count ++;
            }

            return ans;
        }
};