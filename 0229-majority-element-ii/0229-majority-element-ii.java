class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;
        int freq = n/3;
        int count =1;

        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            if(nums[i]== nums[i-1]){
                count ++;
            }else{
                if(count > freq){
                result.add(nums[i-1]);
                }
            count=1;
            }
        }
        if(count > freq){
        result.add(nums[nums.length-1]);
        }
        return result;
    }
}