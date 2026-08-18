class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high =n-1;

        while(low <high){
            int mid = low+(high-low)/2;

            if(nums[mid] <nums[mid+1]){
                //mtlb right mae peak milegi kyuki increase ho rha hai 
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}