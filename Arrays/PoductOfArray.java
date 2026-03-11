/*Problem:  Product of Array Except Self
Platform: LeetCode  238
Difficulty: Medium
Date: 11 March 2026
Topic: Arrays / Prefix Sum
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[]=new int[n];
        ans[0] = 1;

        //prefix
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }

        //suffix
        int suffix = 1;
        for(int i=n-2;i>=0;i--){
            suffix *= nums[i+1];
            ans[i] *= suffix;
        }
        return ans;
    }
}
