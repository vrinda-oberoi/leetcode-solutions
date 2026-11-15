class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int high = 0;
        for(int i = 0;i<n;i++){
            high = Math.max(high,nums[i]);
        }
        int low = 1;
        int ans = 0;

        while(low < high){
            int mid = low+(high-low)/2;
            int sum = 0;
            for(int val : nums){
                if(val < mid || val == mid){
                    sum += 1;
                }else {
                    if(val % mid != 0){
                        int x = val/mid;
                        sum += x+1;
                    }else{
                        sum += val/mid;
                    }
                }
            }

            if(sum <= threshold){
                ans = mid;
                high = mid;
            }else {
                low = mid+1;
            }
        }

        return (ans == 0)? low : ans;
    }
}