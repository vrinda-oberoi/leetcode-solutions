class Solution {
    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int nse[] = new int[n];
        int pse[] = new int[n];

        int mod =(int) 1e9+7;
        long ans=0;

       Arrays.fill(nse, n);
       Arrays.fill(pse, -1);

       st1.push(n-1);

        for(int i=n-2;i>=0;i--){
            int curr = nums[i];
            while(!st1.isEmpty() && nums[st1.peek()] >= curr){
                st1.pop();
            }
            if(!st1.isEmpty()){
                nse[i] = st1.peek();
            }
            st1.push(i);
        }

        for(int i=0;i<n;i++){
            int curr = nums[i];
            while(!st2.isEmpty() && nums[st2.peek()] > curr){
                st2.pop();
            }
            if(!st2.isEmpty()){
                pse[i] = st2.peek();
            }
            st2.push(i);
        }

        for(int i=0;i<n;i++){
            long curr = 1L* (nse[i]-i)*(i-pse[i])*nums[i];
            ans = (ans+curr) %mod;
        }

        return (int)ans;
    }
}