class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int a = arr.length;

        result = new ArrayList<>();
        solve(arr,0,0,n,k,new ArrayList<>());
        return result;
    }

    public void solve(int arr[],int idx,int count,int target,int k,ArrayList<Integer>ans){
       if(idx == arr.length){
          if(count == k && target == 0){
           result.add(new ArrayList<>(ans));
          }
        return;
       }
        
        if( arr[idx] <= target && count <= k){
        ans.add(arr[idx]);
        solve(arr,idx+1,count+1,target-arr[idx],k,ans);
        ans.remove(ans.size()-1);
        }

        solve(arr,idx+1,count,target,k,ans);
    }
}