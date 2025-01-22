# include <bits/stdc++.h>
using namespace std;

/*
Given a string s and an integer k, return true if you can use all the characters in s to construct non-empty k 
palindrome strings
 or false otherwise.

 

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
 
vlc screen:// :screen-fps=30 :screen-caching=100 --sout '#transcode{vcodec=mp4v,vb=4096,acodec=mpga,ab=256,scale=1,width=1280,height=800}:rtp{dst=0.0.0.0,port=1234,access=udp,mux=ts}
Constraints:

1 <= s.length <= 10^5
s consists of lowercase English letters.
1 <= k <= 10^5
*/

class Solution {
public:
    /* solution come from observation:
        1) constrain 10^5 means solution should be max nlogn , means brutforce of findig all will not work
        2) I dont have study any algo which can find palindrome in nlogn means observation base soln can be answer
        3) study the eg , 1) eg shows diffrent way we can make palindome 2) eg show : false case K>no of even count of character , 3rd eg shows if size of string == k alwys true , combine all condition 
        4) after all 3 observation , in this type of question its alwys best is find all false case , if not able to make it false , then pass true  

    */
    bool canConstruct(string s, int k) {
        if(s.size()<k) return false;
        int count[27] = {0};

        for(char a : s){
            count[a -'a']++;
        }
        int ocount= 0;
        for(int val : count){
            if(val%2 != 0) ocount++;
        }

        return ocount>k ? false : true;
    }
};