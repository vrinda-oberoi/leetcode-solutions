class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> a.length()-b.length());
        int n = words.length;

        int dp[] = new int[n];
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPred(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int ans =1;
        for(int i=0;i<dp.length;i++){
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }

    public boolean isPred(String prev,String curr){
        if(curr.length() != prev.length()+1){
            return false;
        }

        int i=0;
        int j=0;

        while(i < prev.length() && j < curr.length()){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }

        return i == prev.length();
    }
}