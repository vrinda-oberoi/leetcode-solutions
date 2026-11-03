class Solution {
    public String removeKdigits(String num, int k) {
       int n = num.length();

       if(k >= n){
        return "0";
       } 
       
       Stack<Character> st = new Stack<>();
        for(int i = 0;i<n;i++){
          char curr = num.charAt(i);
          while(!st.isEmpty() && k>0 && st.peek() > curr){
             st.pop();
             k--;
          }
          st.push(curr);
        }

        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while(!st.isEmpty()){
            result.append(st.pop());
        }

        result.reverse();

        int i = 0;
        while(i<result.length() && result.charAt(i) == '0'){
            i++;
        }

        if(i == result.length()){
            return "0";
        }

        return result.substring(i);
    }
} 