class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int cnt=0;
        int longest = 0;
        for(int val :set){
            if(!set.contains(val-1)){
                cnt =1;
                int x = val;

                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
            } 

            longest = Math.max(longest,cnt); 
        }
        return longest;
    }
}