class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1];
        return solve(s,0,wordDict,dp);
    }

    public boolean solve(String s , int index,List<String> wordDict,Boolean dp[]){
        if(index == s.length()){
            return true;
        }

        if(dp[index] != null) {
            return dp[index];
        }

        for(int j = index+1 ;j<=s.length();j++){
            String word = s.substring(index,j);

            if(wordDict.contains(word)){
                if(solve(s,j,wordDict,dp)){
                    return dp[index] = true;
                }
            }
        }

        return dp[index] =false;
    }
}