class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty()){
                char last = st.peek();
                if(isPair(last,ch)){
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
        }

        return st.isEmpty();
    }

    public boolean isPair(char last,char ch){
        if(last == '(' && ch == ')') return true;
        if(last == '{' && ch == '}') return true;
        if(last == '[' && ch == ']') return true;

        return false;
    }
}