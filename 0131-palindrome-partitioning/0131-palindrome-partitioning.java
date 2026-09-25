class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        solve(0,s,new ArrayList<>());
        return result;
    }

    public void solve(int index,String s,ArrayList<String> ans){
        if(index == s.length()){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=index ;i<s.length();i++){
            if(isPalindrome(index,i,s)){
                ans.add(s.substring(index,i+1));
                solve(i+1,s,ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    public boolean isPalindrome(int start,int end,String s){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }

        return true;
    }
}