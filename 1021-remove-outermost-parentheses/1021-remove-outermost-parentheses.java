class Solution {
    public String removeOuterParentheses(String s) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                counter++;
                if(counter > 1){
                    sb.append(ch);
                }
            }else{
                counter--;
                if(counter > 0){
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}