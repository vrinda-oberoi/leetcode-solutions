class Solution {
    public int candy(int[] ratings) {
    //    int n = ratings.length;
    //    int left[] = new int[n];
    //    int right[] = new int[n];

    //    left[0] = 1;
    //    right[n-1] = 1;

    //     for(int i =1;i<n;i++){
    //       if(ratings[i] > ratings[i-1]){
    //          left[i] = left[i-1]+1;
    //       }else{
    //         left[i] = 1;
    //       }
    //     }

    //     for(int i = n-2;i>=0;i--){
    //         if(ratings[i] > ratings[i+1]){
    //             right[i] = right[i+1]+1;
    //         }else{
    //             right[i] = 1;
    //         }
    //     } 

    //     int sum = 0;

    //     for(int i = 0;i<n;i++){
    //         sum += Math.max(left[i],right[i]);
    //     } 

    //     return sum;
        
    //     //brute force 
    //     //TC - O(3N)   SC - O(2N)
        

    int sum = 1;
    int i = 1;
    int n = ratings.length;

    while(i < n){
        if(ratings[i] == ratings[i-1]){
            sum += 1;
            i++;
            continue;
        }

        int peek = 1;
        while(i<n && ratings[i] > ratings[i-1]){
            peek++;
            sum += peek;
            i++;
        }

        int down = 1;
        while(i < n && ratings[i] < ratings[i-1]){
            sum += down;
            down++;
            i++;
        }

        if(down > peek){
            sum += down-peek;
        }
    }
     
     return sum;

    }
}