# include <bits/stdc++.h>
using namespace std;

/*
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]

Output: ["facebook","google","leetcode"]

Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]

Output: ["leetcode"]

Example 3:

Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]

Output: ["cccbb"]

 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.

*/

// brute force O(n^2 * 27)
class bruteforce {

public:
    vector<string> wordSubsets(vector<string>& a, vector<string>& b) {
        vector<vector<int>> bcount(b.size() , vector<int>(27,0));
        vector<vector<int>> acount(a.size() , vector<int>(27,0));
        for(int i = 0; i<a.size();i++){ // o(n*10)
            string val = a[i];
            fill(val , acount[i]);

        }
        for(int i = 0; i<b.size();i++){ // o(n*10)
            string val = b[i];
            fill(val , bcount[i]);

        }
        vector<string> ans;

        // for(auto val : acount){
        //     for(auto i : val){
        //         cout<<i<<" ";
        //     }
        //     cout<<endl;
        // }
        int i = 0;
        for(auto one : acount){ // O(n)
            
            bool take = true;
            for(auto two : bcount){ // o(n)
                for(int i = 0;i<26;i++){// o(27)
                    if(two[i]> one[i]){
                        take = false;
                        break;
                    }
                }
                if(!take){
                    break;
                }
            }
            if(take) ans.push_back(a[i]);
            i++;
        }
        return ans;

    }

    void fill(string c , vector<int>& arr){
        for(char a : c){
            arr[a -'a']++;
        }
    }
};


// optimzied soln 
class Solution {
    public:
        vector<string> wordSubsets(vector<string>& a, vector<string>& b) {
            vector<int>bcount(26,0);
            for(int i = 0; i<b.size();i++){ // o(n*10)
                string val = b[i];
                vector<int> temp(26,0);
                fill(val , temp);
                for(int j = 0;j<26;j++){
                    bcount[j] = max(bcount[j] , temp[j]);
                }

            }
            vector<string> ans;

            for(auto one : a){ // O(n*10*27)
                bool take = true;
                vector<int> temp(26,0);
                fill(one,temp);
                for(int j = 0;j<26;j++){
                    if(bcount[j] > temp[j]){
                        take = false;
                        break;
                    }
                }
                if(take)ans.push_back(one);
            }
            return ans;

        }

        void fill(string c , vector<int>& arr){
            for(char a : c){
                arr[a -'a']++;
            }
        }
};