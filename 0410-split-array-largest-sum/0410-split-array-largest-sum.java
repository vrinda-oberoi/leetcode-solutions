class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        int total=nums[0];
        for(int i=1;i<n;i++){
            total +=nums[i];
            if(nums[i] > max){
              max = nums[i];
            }
        }

        int low = max;
        int high = total;
        int result =high;
        while(low <=high){
           int mid = low+(high-low)/2;
           int sub =1;
           int sum = 0;

           for(int i=0;i<n;i++){
            sum += nums[i];

            if(sum > mid){
                sub++;
                sum = nums[i];
            }

            if(sub >k){
                break;
            }
           }

           if(sub <= k){
            result = mid;
            high = mid-1;
           }else{
            low = mid+1;
           }
        }
        return result;
    }
}