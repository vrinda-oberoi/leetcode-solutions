class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        
        for( String word:strs){
            char ch[] = word.toCharArray();
            Arrays.sort(ch);

            String value = new String(ch);

            map.putIfAbsent(value,new ArrayList<>());
            map.get(value).add(word);
        }
        return new ArrayList<>(map.values());
    }
}