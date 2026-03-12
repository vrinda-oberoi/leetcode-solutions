/*Problem:  Subarray Sum equals to k
Platform: LeetCode  560
Difficulty: Medium
Date: 12 March 2026
Topic: Arrays / Prefix Sum /HashTable
*/
import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//prefixsum,freq

        int preSum=0;
        int ans=0;

        for(int i=0;i<n;i++){
            preSum+=nums[i];
            //check kro kya presum hashtable mae already present hai
            if(map.containsKey(preSum-k)){
                ans+=map.get(preSum-k);
            }
            //store krdo current presum into the hash table
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return ans;
    }
}
