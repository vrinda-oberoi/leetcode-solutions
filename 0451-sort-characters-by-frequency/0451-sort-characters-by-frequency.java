class Solution {
    public String frequencySort(String s) {
        StringBuilder ans =new StringBuilder();
        int freq[] = new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }

        while(ans.length() < s.length()){
            int max = 0;

            for(int i=1;i<freq.length;i++){
                if(freq[i] > freq[max]){
                    max=i;
                }
            }

            for(int i=0;i<freq[max];i++){
                ans.append((char)max);
            }
            freq[max] =0;
        }
        return ans.toString();
    }
}