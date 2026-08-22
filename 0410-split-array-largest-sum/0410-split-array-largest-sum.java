class Solution {
    public int splitArray(int[] nums, int k) {
        int max =0;
        int total =0;
        int ans=0;

        for(int num:nums){
            total += num;
            max = Math.max(num,max);
        }

        int low = max;
        int high = total;

        while(low <= high){
            int mid = low +(high-low)/2;
            int sub =1;
            int val=0;
            for(int i=0;i<nums.length;i++){
                val += nums[i];
                if(val > mid){
                    sub++;
                    val = nums[i];
                }
                if(sub >k){
                    break;
                }
            }
            if(sub <= k){
                ans = mid;
                high =mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}