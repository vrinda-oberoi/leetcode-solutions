class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
         result = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return result;
        }

        solve(nums,new ArrayList<>(),0);
        return result;
    }

    public void solve(int[] nums ,ArrayList<Integer>ans,int idx){
        if(idx >= nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[idx]);
        solve(nums,ans,idx+1);
        ans.remove(ans.size()-1);

        solve(nums,ans,idx+1);
    }
}