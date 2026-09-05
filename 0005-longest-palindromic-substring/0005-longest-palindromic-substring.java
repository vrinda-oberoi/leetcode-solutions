import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        int start =0 ;
        int end = 0;
        
        for(int i=0;i<s.length();i++){
            int len1 = isPalindrome(s,i,i);
            int len2 = isPalindrome(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len > end-start+1){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int isPalindrome(String sub ,int left,int right){
        while(left >= 0 && right <sub.length() && sub.charAt(left) == sub.charAt(right)){
            left--;
            right++;
        }
        return right -left -1;
    }
}