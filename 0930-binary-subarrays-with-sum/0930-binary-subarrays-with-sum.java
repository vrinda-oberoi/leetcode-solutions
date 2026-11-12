class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        return solve(nums,goal,n) - solve(nums,goal-1,n); 
    }

    private int solve(int nums[],int goal,int n){
        int l = 0;
        int r = 0;

        if(goal < 0){
            return 0;
        }
        
        int curr = 0;
        int count =0;

        while(r < n){
            curr += nums[r];
            
            while (curr > goal) {
                curr -= nums[l];
                l++;
            }

            count += (r-l+1);
            r++;
        }

        return count;
    }
}