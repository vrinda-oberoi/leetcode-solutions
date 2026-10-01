class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hash[] = new int[256];
        int l = 0;
        int r=0;
        int maxLen = 0;

        while(r < n){
            char ch = s.charAt(r);
            hash[ch]++;

            while(hash[ch] > 1){
                char left = s.charAt(l);
                hash[left]--;
                l++;
            }

            int len = r-l+1;
            maxLen = Math.max(maxLen,len);
            r++;
        }

        return maxLen;
    }
}