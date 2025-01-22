#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
long long  moveRobot1(int r1, int c1, vector<vector<int>>& grid, vector<vector<long long>>& dp) {
    int n = grid[0].size();

    // Base case: Robot 1 reaches the destination (1, n-1)
    if (r1 == 1 && c1 == n - 1) {
        return grid[r1][c1];
    }

    // Check memoization table
    if (dp[r1][c1] != -1) {
        return dp[r1][c1];
    }

    long long result = 0;
    // Move right if possible
    if (c1 + 1 < n) {
        result = max(result, (long long)grid[r1][c1] + moveRobot1(r1, c1 + 1, grid, dp));
    }
    // Move down if possible
    if (r1 + 1 < 2) {
        result = max(result, (long long)grid[r1][c1] + moveRobot1(r1 + 1, c1, grid, dp));
    }

    // Store the result in memo table
    dp[r1][c1] = result;
    return result;
}

https://leetcode.com/problems/grid-game/solutions/5821373/best-solution-you-can-find-telling-why-dp-is-not-working/?envType=daily-question&envId=2025-01-21