class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long currSum = 0;

        for(int i=0;i<k;i++){
            currSum += nums[i];
        }

        long maxSum = currSum;

        for(int i=k;i<nums.length;i++){
            currSum += nums[i] -nums[i-k];
            maxSum = Math.max(currSum,maxSum);
        }

        return (double) maxSum/k;
    }
}