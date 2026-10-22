class NumArray {
    private int tree[];
    private int nums[];
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n+1];

        //build the fenwick tree
        for(int i=0;i<n;i++){
            for(int j = i+1;j<=n;j +=(j &(-j))){
                tree[j] += nums[i];
            }
        }
    }
    
    public void update(int index, int val) {
        int change = val - nums[index];
        for(int i = index+1;i<=n;i +=(i&(-i))){
            tree[i] += change;
        }

        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return query(right+1) - query(left);
    }

    private int query(int i){
        int ans = 0;
        while( i> 0){
            ans += tree[i];
            i -= (i & (-i));
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */