#include<bits/stdc++.h>
using namespace std;

/*
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.
*/
class Solution {
public:
    string clearDigits(string s) {
        int i = 0;
        while(i>=0 && i<s.size()){
            char a = s[i];
            cout<<a<<" : "<<i<<endl;
            if(a>= '0' && a<='9'){// we have digit
                s.erase(i,1);
                s.erase(i-1,1);
                i--;
                continue;  // no i++ since all are shifted to left
            }
            i++;
        }
        return s;
    }
};