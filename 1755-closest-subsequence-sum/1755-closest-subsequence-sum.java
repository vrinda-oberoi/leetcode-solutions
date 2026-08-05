 // the approach is first we will divide the array into two half and for each left half and right half we will find the subsequences separately then later on  we will start from one half suppose left and try to find out the lower bound of that element in right half and check if it is near the goal or not and return . the ans can be present in only left half , in only right half or in combination pf both left and right half . 
class Solution {
    private void generate(int[] nums,int start,int end,long sum,ArrayList<Long> list){
       if(start == end){
        list.add(sum);
        return;
       }
       //case 1 don't take value 
       generate(nums,start+1,end,sum,list);

       //case 2 take the value
       generate(nums,start+1,end,sum+nums[start],list);
    }

    private int lowerBound(ArrayList<Long> List , long target){
        int low = 0;
        int high = List.size();

        while(low < high){
            int mid = low + (high-low)/2;

            if(List.get(mid) < target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public int minAbsDifference(int[] nums, int goal) {

        int n = nums.length;
        int mid = n/2;

        ArrayList<Long> leftHalf = new ArrayList<>();
        ArrayList<Long> rightHalf = new ArrayList<>();

        generate(nums,0,mid,0L,leftHalf);
        generate(nums,mid,n,0L,rightHalf);

        Collections.sort(rightHalf);

        long ans = Long.MAX_VALUE;

        // Only left half
        for (long sum : leftHalf) {
            ans = Math.min(ans, Math.abs(sum - goal));
        }

        // Only right half
        for (long sum : rightHalf) {
            ans = Math.min(ans, Math.abs(sum - goal));
        }

        //combination of left and right
        for (long left : leftHalf) {

            long target = goal - left;

            int idx = lowerBound(rightHalf, target);

            if (idx < rightHalf.size()) {
                ans = Math.min(ans,
                        Math.abs(left + rightHalf.get(idx) - goal));
            }

            if (idx > 0) {
                ans = Math.min(ans,
                        Math.abs(left + rightHalf.get(idx - 1) - goal));
            }
        }

        return (int) ans;   
    }
}