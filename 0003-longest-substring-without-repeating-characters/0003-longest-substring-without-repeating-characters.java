class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n  = s.length();
        int count = 0;
        int left = 0;
        int freq[] = new int[256];

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            freq[ch]++;

           while(freq[ch] >1){
            char leftchar = s.charAt(left);
            freq[leftchar]--;
            left++;
           }

           int len = i - left + 1;
           count = Math.max(count,len);
        }
        return count;
    }
}