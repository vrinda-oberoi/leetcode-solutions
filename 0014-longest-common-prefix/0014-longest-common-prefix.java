class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];

        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();

        while(i<first.length()){
            if(first.charAt(i) == last.charAt(j)){
                ans.append(first.charAt(i));
                i++;
                j++;
            }else{
                break;
            }
        } 

        String result = ans.toString();
        return result;
    }
}