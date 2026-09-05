class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        String ans = s+s;
        for(int i=0;i<ans.length();i++){
            if(ans.contains(goal)){
                return true;
            }
        }
        return false;
    }
}