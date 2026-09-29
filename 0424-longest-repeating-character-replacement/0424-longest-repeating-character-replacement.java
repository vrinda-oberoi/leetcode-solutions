class Solution {
    public int characterReplacement(String s, int k) {
       int l =0;
       int r =0;
       int maxLen = 0;
       int maxFreq = 0;

       int hash[] = new int[26];

       while(r < s.length()){
          int ch = s.charAt(r) -'A';
          hash[ch]++;

          maxFreq = Math.max(maxFreq,hash[ch]);

          if((r-l+1)-maxFreq > k){
            //invalid
            hash[s.charAt(l)-'A']--;
            maxFreq = 0;
            for(int i=0;i<26;i++){
                maxFreq = Math.max(maxFreq,hash[i]);
            }

            l++;
          }

          if((r-l+1)-maxFreq <=k){
            maxLen = Math.max(maxLen,(r-l+1));
          }

          r++;
       }

       return maxLen;
    }
}