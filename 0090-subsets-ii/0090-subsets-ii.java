class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        solve(nums,0,n,new ArrayList<>());
        return result;
    }

    public void solve(int nums[],int idx,int n,ArrayList<Integer>ans){
        result.add(new ArrayList<>(ans));
        for(int i = idx;i<n;i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }

            ans.add(nums[i]);
            solve(nums,i+1,n,ans);
            ans.remove(ans.size()-1);
        }
    }
}