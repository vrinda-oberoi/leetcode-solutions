class Solution {
    public long time(int piles[],int mid){
        long taken = 0;
        for(int i:piles){
            taken += (i+mid-1)/mid;
        }
        return taken;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           max = Math.max(piles[i],max);
        }

        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low+(high-low)/2;
            long hours = time(piles,mid);

            if(hours <= h){
                ans = mid;
                high =mid-1;
            }else{
                low =mid+1;
            }
        }
        return ans;
    }
}