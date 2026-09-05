class Solution {
    public int maxDepth(String s) {
        int max = Integer.MIN_VALUE;
        int val = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                val++;
            }
            if(s.charAt(i) == ')'){
                val--;
            }

            if(val > max){
                max = val;
            }
        }
        return max;
    }
}