#include<bits/stdc++.h>
#include <queue>

/*
407. Trapping Rain Water II
Solved
Hard
Topics
Companies
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 

Constraints:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104
*/
using namespace std;



class Solution {
    struct data
    {
        int i , j , h = -1;
        
    };
    using d2 = vector<vector<int>>;
    d2 dir = {{0,1}, {0,-1} , {1,0} , {-1,0}};

    bool isValid(int row, int col, int numOfRows, int numOfCols) {
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols;
    }

public:
    int trapRainWater(vector<vector<int>>& arr) {
        auto cmp = [](data &a , data &b){
            return a.h>b.h;
        };

        int ans = 0 , n = arr.size() , m = arr[0].size();
        d2 visi(n,vector<int>(m,-1));

        priority_queue<data , vector<data>, decltype(cmp)> pq(cmp);

        // adding boundarys elements which holds the water
        for(int i = 0;i<n;i++){
            pq.push({i,0,arr[i][0]});
            pq.push({i,m-1,arr[i][m-1]});
            visi[i][0] = 1 , visi[i][m-1] = 1;
        }

        for(int i = 0;i<m;i++){
            pq.push({0,i,arr[0][i]});
            pq.push({n-1,i,arr[n-1][i]});
            visi[0][i] = 1 , visi[n-1][i] = 1;
        }

        //bfs
        while(!pq.empty()){
            data curr = pq.top(); // curr is parent actually
            pq.pop();

            
            // check all 4 nbrs
            for(int i = 0;i<4;i++){
                int nbri = curr.i +dir[i][0] , nbrj = curr.j+dir[i][1] , wall = curr.h;
                if( isValid(nbri , nbrj , n , m) && visi[nbri][nbrj] == -1  ){
                    // cout<<nbri<<" : "<<nbrj<<endl;
                    visi[nbri][nbrj] = 1; // mark visi
                    if(curr.h > arr[nbri][nbrj]){
                        ans += curr.h - arr[nbri][nbrj];
                    }
                    pq.push({nbri , nbrj, max(curr.h , arr[nbri][nbrj])});
                }
            }
        }
        return ans;
    }
    
};