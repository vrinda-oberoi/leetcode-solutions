class Solution {
    
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPos = (n+1)/2;
        long oddPos =  n/2;

        long evenWays = calPower(5,evenPos);
        long oddWays = calPower(4,oddPos);

        return (int)((evenWays * oddWays)% MOD);
    }

    public long calPower(long base,long n){
        if(n == 0){
            return 1;
        }

        long half = calPower(base,n/2);
        long result = (half * half) % MOD;
        
        if(n % 2 == 1){
            result = (result * base) % MOD;
        }

        return result;
    }
}