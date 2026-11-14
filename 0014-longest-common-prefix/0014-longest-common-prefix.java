class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length -1];

        StringBuilder ans = new StringBuilder();
        int j=0;int i =0;
        while(i<first.length()){
            if(first.charAt(i) == last.charAt(j)){
               ans.append(first.charAt(i));
               i++;
               j++;
            }else{
                break;
            }
        }

        return ans.toString();
    }
}