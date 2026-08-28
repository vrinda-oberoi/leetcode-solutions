class Solution {
    public static void printParenthesis(List<String> result,String str,int n,int open,int close){
        if(str.length() == n*2){
            result.add(str);
            return;
        }

        if(open > close){
            printParenthesis(result,str + ")",n,open,close+1);
        }

        if(open < n){
            printParenthesis(result,str +"(",n,open+1,close);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        printParenthesis(result,"",n,0,0);
        return result;
    }
}