class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int freq[] =new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) -'A']++;
        }

        for(int j=0;j<t.length();j++){
            freq[t.charAt(j) -'A']--;
        }

        for(int k=0;k<freq.length;k++){
            if(freq[k] != 0){
                return false;
            }
        }
        return true;
    }
}