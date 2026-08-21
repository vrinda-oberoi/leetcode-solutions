class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m*k > n){
            return -1;
        }

        int low =Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i:bloomDay){
            low = Math.min(i,low);
            high = Math.max(i,high);
        }

        int ans =0;

        while(low <= high){
            int mid =low+(high-low)/2;
            if(canMake(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean canMake(int bloomDay[],int m,int k,int mid){
        int count =0;
        int bouq =0;

        for(int i:bloomDay){
            if(i <= mid){
                count++;
                if(count == k){
                    bouq++;
                    count =0;
                }
            }else{
                count =0; // adjacent seq toot gya hai yhn pr 
            }
        }
      return bouq >= m;
    }
}