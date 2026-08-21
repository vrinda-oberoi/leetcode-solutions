class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int ans =0;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(num,max);
        } 

        int low =1;
        int high =max;

        while(low <=high){
            int mid = low +(high-low)/2;
            int val = check(nums,mid);

            if(val <=threshold){
                ans =mid;
                high =mid-1;
            }else{
                low =mid+1;
            }
        }
        return ans;
    }
    public int check(int nums[],int mid){
        int sum=0;
        for(int num:nums){
            sum += (num+mid-1)/mid;
        }
        return sum;
    }
}