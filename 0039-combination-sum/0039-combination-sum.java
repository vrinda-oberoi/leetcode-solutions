class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        solve(candidates,target,0,new ArrayList<>());
        return result;   
    }

    public void solve(int arr[],int target,int idx,ArrayList<Integer> ans){

        int n = arr.length;
        if(idx == n){
            if(target == 0){
                result.add(new ArrayList<>(ans));
                return;
            }else{
                return;
            }
        }

        if(arr[idx] <= target){
            ans.add(arr[idx]);
            solve(arr,target-arr[idx],idx,ans);
            ans.remove(ans.size()-1);
        }

        solve(arr,target,idx+1,ans);
    }
}