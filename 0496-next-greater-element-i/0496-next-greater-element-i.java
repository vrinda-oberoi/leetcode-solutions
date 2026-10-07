class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int ans[] = new int[n];
        int nge[] = new int[m];
        Stack<Integer> st = new Stack<>();
        for(int i=m-1;i>=0;i--){
            if(st.isEmpty()){
                nge[i] = -1;
                st.push(nums2[i]);
            }
           else if(nums2[i] < st.peek()){
                nge[i] = st.peek();
                st.push(nums2[i]);
            }else{
                while(!st.isEmpty() && nums2[i] > st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                   nge[i] = -1;
                }else{
                   nge[i] = st.peek();
                }
                st.push(nums2[i]);
            }
        }

        // for(int j=0;j<n;j++){
        //     for(int k = 0;k<m;k++){
        //       if(nums1[j] == nums2[k]){
        //         ans[j] = nge[k];
        //         break;
        //       } 
        //     }
        // }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            map.put(nums2[i],nge[i]);
        }

        for(int j = 0;j<n;j++){
            ans[j] = map.get(nums1[j]);
        }
        return ans;
    }
}