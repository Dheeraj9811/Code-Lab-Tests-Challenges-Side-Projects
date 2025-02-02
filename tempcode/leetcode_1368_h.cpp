#include<bits/stdc++.h>
using namespace std;

/*
 Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

 

Example 1:


Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
Output: 3
Explanation: You will start at point (0, 0).
The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
The total cost = 3.
Example 2:


Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
Output: 0
Explanation: You can follow the path from (0, 0) to (2, 2).
Example 3:


Input: grid = [[1,2],[4,3]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
1 <= grid[i][j] <= 4
*/




// TC: 4^(n*M) backtracking
class brutforce {
    int ans = INT_MAX;
    int n , m;
    using darray = vector<pair<int, int>>;
    darray dir = {{0,1}, {0 , -1} , {1,0} , {-1,0}}; 
    
public:
    int minCost(vector<vector<int>>& grid) {
        n = grid.size() , m = grid[0].size();
        dfs(0,0,grid,  vector<vector<int>>(n, vector<int>(m, 0)) , 0);
        return ans;
    }
    private:
    void dfs(int i , int j , vector<vector<int>>& arr , vector<vector<int>>&& visi , int cost){
        if(i<0 || j<0 || i>=n || j>=m || visi[i][j]) return;
        if(i == n -1 && j== m-1){
            ans = min(cost , ans);
            return;
        }
        visi[i][j] = 1;
        for(int i_ = 0;i_<4;i_++){
            int diri = dir[i_].first;
            int dirj = dir[i_].second;
            int dire =  arr[i][j];

            dfs(diri,dirj,arr,move(visi),cost+(dire == i-1) ? 0:1);
        }
        visi[i][j] = 0;
        
    }
};


//  tc:(n^2) since dense graph , if it was sparse then it can be (v+E)log(v)
class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> cost(n, vector<int>(m, INT_MAX)); // DP table to track min cost
        deque<pair<int, int>> dq;  // Deque for 0-1 BFS (Dijkstra-like)
        vector<pair<int, int>> dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        cost[0][0] = 0;
        dq.push_front({0, 0}); // Start from (0,0) with 0 cost

        while (!dq.empty()) {
            auto [i, j] = dq.front();
            dq.pop_front();

            for (int d = 0; d < 4; d++) {
                int ni = i + dir[d].first, nj = j + dir[d].second;
                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                int extraCost = (grid[i][j] == d + 1) ? 0 : 1;
                if (cost[i][j] + extraCost < cost[ni][nj]) {
                    cost[ni][nj] = cost[i][j] + extraCost;
                    if (extraCost == 0) {
                        dq.push_front({ni, nj}); // Higher priority for 0-cost moves
                    } else {
                        dq.push_back({ni, nj}); // Lower priority for +1 cost moves
                    }
                }
            }
        }
        return cost[n - 1][m - 1];
    }
};