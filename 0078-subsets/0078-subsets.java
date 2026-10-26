class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0||nums == null){
            return result;
        }
        solve(nums,0,new ArrayList<>());
        return result;
    }

    public void solve(int[] nums,int index,ArrayList<Integer> ans){
        if(index >= nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        
        ans.add(nums[index]);
        solve(nums,index+1,ans);
        ans.remove(ans.size()-1);

        solve(nums,index+1,ans);
    }
}