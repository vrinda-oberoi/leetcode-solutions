class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i=0;

        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        int sign =1;

        if(i < n && (s.charAt(i) == '+'|| s.charAt(i) == '-')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        return convert(s,i,sign,0);
    }

    public int convert(String s,int i,int sign,int num){
       if( i == s.length() || !Character.isDigit(s.charAt(i))){
        return sign * num;
       }

       int digit = s.charAt(i)-'0';

       if(num > Integer.MAX_VALUE /10 || num == Integer.MAX_VALUE/10 && digit >7){
        return sign == 1?Integer.MAX_VALUE : Integer.MIN_VALUE;
       }

       num = num * 10 +digit;

       return convert(s,i+1,sign,num);
    }
}