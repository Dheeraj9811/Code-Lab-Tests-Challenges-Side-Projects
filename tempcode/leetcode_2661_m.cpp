#include<bits/stdc++.h>

/*
2661. First Completely Painted Row or Column
Solved
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.

Example 1:

image explanation for example 1
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
Example 2:

image explanation for example 2
Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].
 

Constraints:

m == mat.length
n = mat[i].length
arr.length == m * n
1 <= m, n <= 105
1 <= m * n <= 105
1 <= arr[i], mat[r][c] <= m * n
All the integers of arr are unique.
All the integers of mat are unique.
*/

class Solution {
public:
    int firstCompleteIndex(std::vector<int>& arr, std::vector<std::vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        int* map = new int[100001];
        std::fill(map, map + 100001, -1); // sc: 10^5
        // TC 10^5 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                map[mat[i][j]] = encode(i , j , m);
            }
        }
        //  conbination of r and c is 10^5
        std::vector<int> r(n ,0);  
        std::vector<int> c(m,0);
        // TC 10^5
        for(int k = 0;k<m*n;k++){
            int const val = arr[k];
            int i ; int j;
            decode(map[val],m,i,j);
            if(++r[i] >=m){
                delete[] map;
                return k;
            }
            if(++c[j] >=n){ 
                delete[] map;
                return k;
            }
        }
        delete[] map;
        return -1;



    }
    int encode(int i , int j, int m){
        return (i*m + j);
    }
    void decode(int value, int cols, int &i, int &j) {
    i = value / cols;
    j = value % cols;
}
};