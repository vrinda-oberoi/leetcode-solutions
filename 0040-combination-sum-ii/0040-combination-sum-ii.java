class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        
        Arrays.sort(candidates);
        solve(candidates,0,target,new ArrayList<>());
        return result;
    }

    public void solve(int arr[],int idx,int target, ArrayList<Integer> ans){
        int n = arr.length;

        if( target == 0){
            result.add(new ArrayList<Integer>(ans));
            return;
        }

        if(idx == n && target !=0){
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(arr[i] > target) break;

            if(i>idx && arr[i] == arr[i-1]) continue;
            
            ans.add(arr[i]);
            solve(arr,i+1,target-arr[i],ans);
            ans.remove(ans.size()-1);
        
        }
    }
}