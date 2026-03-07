/*Problem: Longest SubString without repetition
Platform: LeetCode  3
Difficulty: Medium
Date: 7 March 2026
Topic: Arrays / String*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n= s.length();
      int longest=0;
      int left=0;
      int arr[] = new int[256];

      for(int right=0;right<n;right++){
        char ch = s.charAt(right);
        arr[ch]++;

        while(arr[ch] > 1){
            arr[s.charAt(left)]--;
            left++;
        }

        int length = right-left+1;
        longest =Math.max(longest,length);
      } 
      return longest;
    }
}
