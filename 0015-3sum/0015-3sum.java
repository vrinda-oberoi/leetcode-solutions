class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    //  Set<List<Integer>> ans = new HashSet<>();

    //     for(int i=0;i<nums.length;i++){
    //         Set<Integer> set = new HashSet<>();
    //          for(int j=i+1;j<nums.length;j++){
    //                 int third = -(nums[i]+nums[j]);

    //                 if(set.contains(third)){
    //                 List<Integer> temp = new ArrayList<>();
    //                 temp.add(nums[i]);
    //                 temp.add(nums[j]);
    //                 temp.add(third);
                    
    //                 Collections.sort(temp);
    //                 ans.add(temp);
    //                 }

    //                 set.add(nums[j]);
    //             }    
    //         }
    //  return new ArrayList<>(ans);


    // Optimal approach
     
     List<List<Integer>> ans = new ArrayList<>();
     Arrays.sort(nums);
     int n= nums.length;
      
     for(int i=0;i<n;i++){
        if(i>0 && nums[i] == nums[i-1]){
            continue;
        }

        int j = i+1;
        int k = n-1;

        while(j<k){
            int sum = nums[i]+nums[j]+nums[k];

            if(sum == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);

                ans.add(temp);

                j++;
                k--;

                while(j<k && nums[j] == nums[j-1]){
                    j++;
                }

                while(j < k && nums[k] == nums[k+1]){
                    k--;
                }
            }

            else if(sum <0){
                j++;
            }else{
                k--;
            }
        }
     }
     return ans;
    }
}