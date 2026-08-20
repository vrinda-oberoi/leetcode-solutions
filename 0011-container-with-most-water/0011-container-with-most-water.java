class Solution {
    public int maxArea(int[] height) {
       int n = height.length;
       int left = 0;
       int right = n-1;

       int ans =Integer.MIN_VALUE;
       while(left < right){
        int width = right-left;
        int heigh = Math.min(height[left],height[right]);
        ans = Math.max(ans,heigh*width);

        if(height[left] > height[right]){
            right--;
        }else if(height[left]<height[right]){
            left++;
        }else{
            left++;
            right--;
        }
       } 
       return ans;
    }
}