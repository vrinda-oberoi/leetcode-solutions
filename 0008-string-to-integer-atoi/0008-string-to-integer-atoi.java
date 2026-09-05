class Solution {
    public int myAtoi(String s) {
       if(s == null || s.length() == 0){
          return 0;
        }

        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;

        int i=0;
        int n =s.length();

        //step 1 white spaces
        while(i<n && s.charAt(i) == ' '){
            i++;
        } 

        if( i == n){
            return 0;
        }

        //step 2 sign
        int sign = 1;
        if(s.charAt(i) == '+'){
            i++;
        }else if(s.charAt(i) == '-'){
            sign =-1;
            i++;
        }

        //step 3 read digits
        long res=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) -'0';
            res = res*10+digit;

            if(sign *res <= INT_MIN){
                return INT_MIN;
            }
            if(sign * res >=INT_MAX){
                return INT_MAX;
            }
            i++;
        }

        //step 4 return ans
        return (int) (res *sign);
    }
}