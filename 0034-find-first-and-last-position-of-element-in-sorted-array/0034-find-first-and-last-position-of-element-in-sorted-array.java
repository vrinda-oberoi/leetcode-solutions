class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int ans[] ={-1,-1};
        //first time
        int low=0;
        int high = n-1;

        while(low <= high){
            int mid =low+(high-low)/2;
            if(nums[mid] == target){
                ans[0]= mid;
                high = mid-1;
            }else if(nums[mid] <target){
                low = mid+1;
            }else{
                high =mid-1;
            }
        }

        //last occurrence
        low =0;
        high = n-1;
        while(low <=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                ans[1] =mid;
                low = mid+1;
            }else if(nums[mid] <target){
                low = mid+1;
            }else{
                high = mid-1;
            }   
        }
        return ans;
    }
}