class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0 ;
        int high = m-1;

        while(low <= high){
            int col = low +(high-low)/2;//col
            int row = maxElement(mat,col);

            int left = col-1 >=0 ? mat[row][col-1] : Integer.MIN_VALUE;
            int right = col+1 < m ? mat[row][col+1] :Integer.MIN_VALUE;

            if(mat[row][col] > left && mat[row][col] > right){
                return new int[]{row,col};
            }else if(mat[row][col] < left){
                high = col-1;
            }else{
                low = col+1;
            }
        }

        return new int[] {-1,-1};
    }

    public int maxElement(int arr[][],int val){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int idx =-1;

        for(int i=0;i<n;i++){
            if(arr[i][val] > max){
                max = arr[i][val];
                idx = i;
            }
        }

        return idx;
    }
}