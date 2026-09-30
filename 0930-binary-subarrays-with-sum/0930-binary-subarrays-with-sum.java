class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return check(nums,goal) - check(nums,goal-1);
    }
    public int check(int[] nums, int goal) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;

        if(goal < 0){
            return 0;
        }

        while(r<n){
            sum += nums[r];

            while(sum >goal){
                sum -= nums[l];
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}