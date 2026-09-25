class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }

        String mapping[] ={
            "", //0
            "", //1
            "abc",//2
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        solve(digits,0,"",mapping);
        return result;
    }

    public void solve(String digits,int index,String curr,String mapping[]){
        if(index == digits.length()){
            result.add(curr);
            return;
        }

        int digit = digits.charAt(index)-'0';

        String letters = mapping[digit];

        for(int i=0;i<letters.length();i++){
            char ch = letters.charAt(i);

            solve(digits,index+1,curr+ch,mapping);
        }
    }
}