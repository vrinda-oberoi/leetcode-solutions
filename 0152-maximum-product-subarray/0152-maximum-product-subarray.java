class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int largest = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int product = 1;
            for(int j =i;j<n;j++){
                product *= nums[j];
                largest = Math.max(largest,product);
            }
        }
        return largest;
    }
}