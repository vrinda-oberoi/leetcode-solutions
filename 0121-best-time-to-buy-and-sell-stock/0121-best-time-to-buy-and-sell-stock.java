class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;

        for(int i = 1;i<n;i++){
            if(i < n-1 && prices[i] < buy){
                buy = prices[i];
            }
            profit = Math.max(profit,prices[i]-buy);
        }

        return profit;
    }
}