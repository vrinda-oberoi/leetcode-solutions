class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>  ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<=s.length()-10;i++){
            String sub = s.substring(i,i+10);
            map.put(sub,map.getOrDefault(sub,0)+1);
        }

        for(String str : map.keySet()){
            if(map.get(str) > 1){
                ans.add(str);
            }
        }
        return ans;
    }
}