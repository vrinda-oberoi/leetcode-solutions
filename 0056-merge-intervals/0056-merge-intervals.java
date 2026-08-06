class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

       List<List<Integer>> ans = new ArrayList<>();
       for(int interval[] : intervals){
           if(ans.isEmpty() || ans.get(ans.size()-1).get(1) < interval[0]){
            //add new block 
            ans.add(Arrays.asList(interval[0],interval[1]));
           }else{
            //overlapping
            int last = ans.size()-1;
            int maxEnd = Math.max(ans.get(last).get(1) , interval[1]);
            
            ans.get(last).set(1,maxEnd);
           }
       }
       int result[][] = new int[ans.size()][2];

       for(int i=0;i<ans.size();i++){
        result[i][0] = ans.get(i).get(0);
        result[i][1] = ans.get(i).get(1);
       }
       return result;
    }
}