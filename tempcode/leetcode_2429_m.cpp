# include <bits/stdc++.h>
using namespace std;
/*
Given two positive integers num1 and num2, find the positive integer x such that:

x has the same number of set bits as num2, and
The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.

 

Example 1:

Input: num1 = 3, num2 = 5
Output: 3
Explanation:
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
Example 2:

Input: num1 = 1, num2 = 12
Output: 3
Explanation:
The binary representations of num1 and num2 are 0001 and 1100, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.
 

Constraints:

1 <= num1, num2 <= 109

*/
class Solution {
public:
    int minimizeXor(int num1, int num2) {
        int nob = 0 , noa = 0;
        int b = num2 , a = num1;
        while(b >0){
            b = b&(b-1);
            ++nob;
        }
        while( a>0){
            a = a&(a-1);
            ++noa;
        }
        int ans = 0;
        if(noa>nob){
            ans = num1;
            while(noa>nob){
                ans = ans&(ans-1);
                noa--;
            }
        }
        else{
            ans = num1;
            while(noa<nob){
                int mask = ~ans&(ans+1);
                ans = ans|mask;
                noa++;
            }
        }

        return ans;

    }
};