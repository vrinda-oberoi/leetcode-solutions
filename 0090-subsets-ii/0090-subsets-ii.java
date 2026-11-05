class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        solve(0,nums,n,new ArrayList<>());
        return result;
    }

    private void solve(int idx,int nums[],int n,ArrayList<Integer>ans){
       result.add(new ArrayList<>(ans));

       for(int i = idx;i<n;i++){
        if(i>idx && nums[i] == nums[i-1]){
            continue;
        }

        ans.add(nums[i]);
        solve(i+1,nums,n,ans);
        ans.remove(ans.size()-1);
       }
    }
}