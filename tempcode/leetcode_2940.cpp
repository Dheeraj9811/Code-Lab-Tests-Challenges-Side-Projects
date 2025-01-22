#include <bits/stdc++.h>
using namespace std;
#include <ctime>
/*You are given a 0-indexed array heights of positive integers, where heights[i] represents the height of the ith building.

If a person is in building i, they can move to any other building j if and only if i < j and heights[i] < heights[j].

You are also given another array queries where queries[i] = [ai, bi]. On the ith query, Alice is in building ai while Bob is in building bi.

Return an array ans where ans[i] is the index of the leftmost building where Alice and Bob can meet on the ith query. If Alice and Bob cannot move to a common building on query i, set ans[i] to -1.

 

Example 1:

Input: heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
Output: [2,5,-1,5,2]
Explanation: In the first query, Alice and Bob can move to building 2 since heights[0] < heights[2] and heights[1] < heights[2]. 
In the second query, Alice and Bob can move to building 5 since heights[0] < heights[5] and heights[3] < heights[5]. 
In the third query, Alice cannot meet Bob since Alice cannot move to any other building.
In the fourth query, Alice and Bob can move to building 5 since heights[3] < heights[5] and heights[4] < heights[5].
In the fifth query, Alice and Bob are already in the same building.  
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.
Example 2:

Input: heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
Output: [7,6,-1,4,6]
Explanation: In the first query, Alice can directly move to Bob's building since heights[0] < heights[7].
In the second query, Alice and Bob can move to building 6 since heights[3] < heights[6] and heights[5] < heights[6].
In the third query, Alice cannot meet Bob since Bob cannot move to any other building.
In the fourth query, Alice and Bob can move to building 4 since heights[3] < heights[4] and heights[0] < heights[4].
In the fifth query, Alice can directly move to Bob's building since heights[1] < heights[6].
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.

 

Constraints:

1 <= heights.length <= 5 * 104
1 <= heights[i] <= 109
1 <= queries.length <= 5 * 104
queries[i] = [ai, bi]
0 <= ai, bi <= heights.length - 1
*/
// struct mpair
// {
//     int val;
//     int ind;
// };

class Solution {
public:
    vector<int> leftmostBuildingQueries(vector<int>& h, vector<vector<int>>& q) {
        int n = h.size();
        vector<int> ans(q.size(), -1); // default answer is not found
        vector<int> arrnbr(n);

        nge(h , arrnbr, n);
        for(int i = 0;i<q.size();i++){
            // unpack
            int a = q[i][0] , b = q[i][1];
            if(a>b) swap(a,b);
            // cout<<"finding answer for index "<<i<<endl;
            if(h[a]<h[b] || a == b ){ ans[i] = b;
                // cout<<"inside first conditon and value is: "<<b<<endl;
            }
            else if(arrnbr[a] >= b){ // hight of a >=b so answer is right side , 2 case when nbr[a] >b index directly take answer from nbr , else anwer need to be find from in range b+1 till end , if no answer is -1
                // cout<<"inside a>=b and value is: "<<arrnbr[a]<<endl; 
                ans[i]= arrnbr[a];
            }
            else if(h[a] >= h[b] && arrnbr[a] != -1 ){
                for(int s = b+1 ; s<n;s++){
                    if(h[s]> h[a]){
                        ans[i] = s;
                        // cout<<"inside else and value is: "<<s<<endl;
                        break;
                    }
                }
            }
        
        }   
    }

    void nge(vector<int> &arr , vector<int>& ans, int &n){
        vector<int> st(n);
        for(int i = n-1 ; i>=0;i--){
            int curr = arr[i];
            while(st.size() !=0 && arr[st.back()]<= curr){
                st.pop_back();
            }
            ans[i] = st.size() == 0 ? -1 : st.back();
            st.push_back(i);
        }

        // printing debug
        cout<<"nbr ans is : ";
        for(auto i : ans){
            if(i == -1){
                cout<<"-1 ";
                continue;
            }
            cout<<arr[i]<<" ";
        }
        cout<<endl;
    }

};

class Solution {
public:
    vector<int> leftmostBuildingQueries(vector<int>& h, vector<vector<int>>& q) {
        int n = h.size() , m = q.size();
        vector<int> ans(m,-1);
        vector<vector<pair<int, int>>> nq(n); 
        for(int i = 0;i<m;i++){
            int a = q[i][0] , b = q[i][1];
            if(a>b) swap(a,b);
            if(h[a]<h[b] || a == b) ans[i] = b;
            else{ // make leftover ready for binary search 
                nq[b].push_back({a,i});
            }
        }
        // using as st but making vector to do binary search
        vector<int> st;
        // all answe here lies in range b to n
        for(int i = n-1;i>=0;i--){  
            
            int curr = h[i];
            if(nq[i].size() != 0){
                // unpack all with same index high
                 for(auto& val : nq[i]){
                    int loc = bs(st,val.first,h); // return index which contains the answer in st
                    // cout<<" ans for index = "<<i<<" b = "<<val.first<<" ind "<<val.second<<endl; 
                    if(loc <st.size() && loc >= 0){
                        ans[val.second] = st[loc];
                    }
                }

            }
            while(st.size() !=0 && h[st.back()] <=curr ){
                st.pop_back();
            }
            st.push_back(i);
        }
        return ans;
    }
 private:
    int bs(vector<int> & arr , auto find , vector<int>&  val){ // return next greatest
        int n = arr.size();
        int l = 0 , h = n-1;
        int ans = -1;
        // cout<<"inside binary search ";
        while(l<=h){
            int mid = l +(h-l)/2;
            // cout<<"printing bs mid and find value "<<val[arr[mid]]<<" "<<val[find]<<endl;
            if(val[arr[mid]] >val[find]){
                l = mid+1;
                ans = mid;
            }
            else{
                h = mid-1;
            }
        }
        return ans;
    }

};
int main(int argc, char const *argv[])
{
    /* code */
    Solution obj;
    vector<int> arr = {6,4,8,5,2,7};
    vector<vector<int>> qur = {{0,1},{0,3},{2,4},{3,4},{2,2}};
    clock_t start, end;
    start = clock();
    cout<<start<<endl;
    vector<int> ans = obj.leftmostBuildingQueries(arr, qur);
    end = clock();
    double duration = double(end - start)* 1000 / CLOCKS_PER_SEC;
    cout<<"time taken = "<<duration<<endl;
    for(int i = 0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }
    cout<<endl;
    return 0;
}
