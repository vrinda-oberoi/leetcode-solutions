class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int prime[] = new int[n];

        for(int i = 2;i<prime.length;i++){
            prime[i] =1;
        }

        for(int i = 2;i<prime.length;i++){
            if(prime[i] == 1){
                for(int j = 2*i;j<prime.length;j += i){
                    prime[j] = 0;
                }
            }
        }

        for(int k =2;k<prime.length;k++){
            if(prime[k] == 1){
                count++;
            }
        }

        return count;
    }
}