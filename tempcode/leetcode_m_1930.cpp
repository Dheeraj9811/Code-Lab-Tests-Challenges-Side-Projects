#include <bits/stdc++.h>
#include <unordered_set>
using namespace std;

/*
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 10^5
s consists of only lowercase English letters.
*/
// brut force
class Solution1 {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.size();
        int ans = 0;
        vector<int> ind(3,0);
        set<vector<char>> st;

        for(int i = 0;i<=n-3;i++ ){
            ind[0] = i;
            for(int j =i+1; j<=n-2 ; j++){
                ind[1] = j;
                for(int k = j+1;k<=n-1;k++){
                    ind[2] = k;
                    if(ispalindrom(ind,s)){
                        st.insert({s[ind[0]] ,s[ind[1]] , s[ind[2]] });

                    }
                }
            }
        }
        return st.size();
    }
private:
    bool ispalindrom(vector<int>& arr, string& s){
        if(s[arr[0]] == s[arr[2]]) return true;
        return false;
    }
};

class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.size();
        vector<int> fs(26,-1) , ls(26,-1);


        //  making array of first and lst character found
        for(int i = 0;i<n;i++){
            int val = s[i]-'a';
            if(fs[val] == -1) fs[val] = i;
            else{
                ls[val] = i;
            }
        }
        unordered_set<char> st;
        int ans = 0;
        for(int i = 0; i<26;i++){
            int indf = fs[i] , inds = ls[i];
            if(indf == -1 || inds == -1) continue;
            // find unique bw element in range 
            unordered_set<char> st;
            for(int i = indf+1 ; i <inds;i++){
                st.insert(s[i]);
            }
            ans += st.size();
        }

        return ans;


    }
};

int main(int argc, char const *argv[])
{
    /* code */
    Solution s;
    string st = "eokjwrihyqmotqcigqxgbxjucgsanunnmhqicczunqfqfrvfvwtlvbrasabegbvxklkikdasbtbwjnhrphyjvaeftuwhqhxzwqyawdbokocftsfxwdeqgcrobtzoqbrgfpyjrghbfmirsdovyeiusqhjrimlumcqchvxftqsxwqvptfagxordkxpwdncjagzzrtdeoowdtybtgggrnukxwbqczqhtpojjpxcgzfkviuxawlfnhdepvrkicrmpqkgdpdnxdexnkzqwsvyfpmmfkdptqnerxpbjdanxrvpexpwntcrxoayrlkwslymtjuxvolgtxcpogatannjfukclpgnopzkfooeomzpukdwdfuycnuuprbkquvmpcgjpsykrhzbuemawynfunsprjrzchkrkfasxosopjvfzlkaenonidngnugljmgiurxwmgjufsukjnsghktioeifoetyetgggfvvjudcymawywjixwohetnktdnlyajwuldniarjcjweghyielktjklozrvsuowfutmakdxqnimgwbcefgvctgjovikjrpoqnzhinulcpmywqykpkxciiqspkxuytnlewdggttfkcymbunzcqc";
    cout<<s.countPalindromicSubsequence(st);
    return 0;
}

