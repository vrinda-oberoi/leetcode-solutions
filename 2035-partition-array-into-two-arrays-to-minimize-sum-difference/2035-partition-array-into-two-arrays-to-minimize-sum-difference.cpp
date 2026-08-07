class Solution {
public:
    void solve(int start,int end,int sum,int len,vector<int>&nums,map<int,set<int>>&st){
        if(start == end){
            st[len].insert(sum);
            return;
        }

        solve(start+1,end,sum+nums[start],len+1,nums,st);
        solve(start+1,end,sum,len,nums,st);
    }
    int minimumDifference(vector<int>& nums) {
       int n = nums.size();
       int mid = n/2;
       map<int,set<int>> st1,st2;
       solve(0,mid,0,0,nums,st1);
       solve(mid,n,0,0,nums,st2);

       int sum = accumulate(nums.begin(),nums.end(),0);
       int ans = 1e9;

       for(auto it:st1){
        int need = mid-it.first;
        for(auto at:it.second){
            int a = at;
            int b = (sum-2*a)/2;

            auto mt = st2[need].lower_bound(b);
            if(mt!= st2[need].end()){
                int curr = *mt;
                int sum1 = a+curr;
                int sum2 = sum-sum1;
                int diff = abs(sum1-sum2);
                ans = min(ans,diff);
            }

            if(mt != st2[need].begin()){
                mt--;
                int curr =*mt;
                int sum1 = a+curr;
                int sum2 = sum-sum1;
                int diff =abs(sum2-sum1);
                ans = min(ans,diff);
            }
        }
       } 
       return ans;
    }
};