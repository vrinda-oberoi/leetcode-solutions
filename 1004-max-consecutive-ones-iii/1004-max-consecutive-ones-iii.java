class Solution {
    public int longestOnes(int[] nums, int k) {
        int r = 0;
        int l = 0;
        int maxLen = 0;
        int n = nums.length;

        while(r<n){
            if(nums[r] == 0){
                k--;
            }

            while(k<0){
                while(nums[l] != 0){
                    l++;
                }
                l++;
                k++;
            }

            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}