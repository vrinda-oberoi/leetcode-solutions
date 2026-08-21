class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //hume sbse phele nikalna cahiye ki ship ki capacity kya hai uski ek fixed range .. agr low ki baat kren toh vo hoga jo humara single max weight hai atleast ship utna uthane ke liye toh eligible hogi hi and max hoga saare weights ka sum . ab range decide hogyi toh ab hum nikalenge days ke acc min weight

        int w = weights.length;
        int result =0;
        int sum=0;
        int max =Integer.MIN_VALUE;
        
        for(int weigh :weights){
            sum += weigh;
            max =Math.max(weigh,max);
        }

        int low = max;
        int high =sum;

        while(low <= high){
            int mid = low+(high-low)/2;
            int val = count(weights,mid);

            if(val <= days){
               result = mid;
               high =mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }

    public int count(int weights[],int mid){
        int day = 1;
        int currSum =0;
        for(int i :weights){
           if(currSum+i > mid){
            day ++;
            currSum=0;
           }
           currSum += i;
        }
        return day;
    }
}