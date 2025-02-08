#include<bits/stdc++.h>
using namespace std;



class Solution {
    struct data{
        int a = 0;
        int b = 0;

        data(int a , int b){
            this->a = a;
            this->b = b;
        }
    };
public:
    vector<int> queryResults(int l, vector<vector<int>>& q) {
        vector<int> count(l+1 , 0);
        vector<int> num(l+1, 0);
        vector<int> ans;
        int c = 0;
        for(auto val : q){
            if(count[val[1]] == 0 && num[val[0]] == 0){
                c++;
                num[val[0]] = val[1];
                count[val[1]]++;
            }
            else if(num[val[0]] != val[1]){ // means same no but different colour 
                //check older color count , if doing -1 make 0 then do c-- , if new colour count is zero do c++ 
                if(count[num[val[0]]] -1 == 0){
                    --c;
                }
                if(count[val[1]] == 0){
                    c++;
                }
                // old ko -- kro
                count[num[val[0]]] = max(count[num[val[0]]]-1 , 0);
                ++count[val[1]];
                num[val[0]] = val[1];
            }
            else{ // same no and same color 
                count[val[1]]++;
                
            }
            


            ans.push_back(c);
            
        }
        return ans;
    }
};