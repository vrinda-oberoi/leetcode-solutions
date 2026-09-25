class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result =new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,new ArrayList<>());
        return result;
    }

    public void solve( int nums[],int index,ArrayList<Integer>ans){
        int n = nums.length;
       
       result.add(new ArrayList<>(ans));

        for(int i=index;i<n;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }

            ans.add(nums[i]);
            solve(nums,i+1,ans);
            ans.remove(ans.size()-1);
        }
    }
}