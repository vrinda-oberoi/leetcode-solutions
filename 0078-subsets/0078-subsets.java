class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums.length == 0||nums == null){
            return result;
        }
        solve(0,nums,new ArrayList<>());
        return result;
    }

    private void solve(int idx,int nums[],ArrayList<Integer> ans){
        if(idx >= nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[idx]);
        solve(idx+1,nums,ans);
        ans.remove(ans.size()-1);

        solve(idx+1,nums,ans);
    }
}