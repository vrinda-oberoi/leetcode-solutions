class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return find(nums,goal) - find(nums,goal-1);
    }

    public int find(int nums[],int goal){

        if(goal < 0) return 0;
        int left = 0;
        int n = nums.length;

        int count = 0;
        int currSum = 0;

       for(int right =0;right<n;right++){
            currSum += nums[right];
            while(currSum >goal){
                    currSum -= nums[left];
                    left++;
            }
            count += right-left+1;
        }

        return count;
    }
}