class Solution {
    public static void reverse(int nums[],int start,int end){
        while(start<end){
            int temp =nums[start];
            nums[start]=nums[end];
            nums[end]=temp;

            start++;
            end--;
        }
    }

    public  void nextPermutation(int nums[]){
        //find pivot
        int pivot=-1;
        int n = nums.length;

        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){//descending order
            reverse(nums,0,n-1);
            return;
        }

        //2 find the next rightmost greater element
        for(int i=n-1;i>=0;i--){
            if(nums[i] > nums[pivot]){//swapping
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot]=temp;
                break;
            }
        }

        //3 reverse 
        reverse(nums,pivot+1,n-1);
    }
}