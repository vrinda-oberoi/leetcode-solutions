class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n-k+1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0;i<n;i++){
            //sabse phele agr out of window elements hai unke remove karo
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            //ab back se vo elements remove kroo jinkii value chotti hai curr element se because wo kabhi ans nhi ho sakte 
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            //add current element in the deque
            dq.offerLast(i);

            //jese hi window size comple ho ans store kara lo 
            if(i >= k-1){
                result[idx] = nums[dq.peekFirst()];
                idx++;
            }

        }
        return result;
    }
}