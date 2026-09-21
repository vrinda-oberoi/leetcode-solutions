class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n  = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp,1);

        int count[] = new int[n];
        Arrays.fill(count,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    if(dp[j]+1 > dp[i] ){
                        dp[i] = dp[j] +1;
                        count[i] = count[j];
                    }else if(dp[j]+1 == dp[i]){
                        count[i] += count[j];//same length ka ek aur mil gya 
                    }
                }
            }
        }

        int maxLen = 0;
        for(int i=0;i<dp.length;i++){
            maxLen = Math.max(maxLen,dp[i]);
        }

        int ans = 0;
        for(int i=0;i<count.length;i++){
            if(dp[i] == maxLen ){
                ans += count[i];
            }
        }
        return ans;
    }
}