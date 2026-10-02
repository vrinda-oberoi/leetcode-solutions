class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int count = 0;
        int n = s.length();

        int freq[] = new int[3];

        while(r < n ){
            char ch = s.charAt(r);
            if(ch == 'a'){
                freq[0]++;
            }else if(ch == 'b'){
                freq[1]++;
            }else{
                freq[2]++;
            }

            while(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1){
                count += n-r;
                if(s.charAt(l) == 'a'){
                    freq[0]--;
                }else if(s.charAt(l) == 'b'){
                    freq[1]--;
                }else{
                    freq[2]--;
                }

                l++;
            }

            r++;
        }

        return count;
    }
}