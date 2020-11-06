package dynamic;

//PROBLEM
/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

https://leetcode.com/problems/longest-palindromic-substring/
 */

//APPROACH
/*
Using bottom up approach, check from end substrings between i & j. If pallindorme found check for longes palindrome till now.
 */

public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            if(s.isEmpty()){
                return s;
            }

            String res = s.substring(0,1);

            boolean[][] dp = new boolean[s.length()][s.length()];

            for(int i=0; i<s.length(); ++i){
                dp[i][i] = true;
            }

            for(int i = s.length()-2; i>=0; --i){
                for(int j = i+1; j<s.length(); ++j){
                    dp[i][j] = (j-i == 1) ? (s.charAt(i) == s.charAt(j)) : ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]);
                    if(dp[i][j]){
                        res = (j-i+1 > res.length()) ? s.substring(i, j+1) : res;
                    }
                }
            }

            return res;
        }
    }
}
