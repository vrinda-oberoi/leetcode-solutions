class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
       if(occupiedIntervals.length == 0){
        return new ArrayList<>();
       } 

       Arrays.sort(occupiedIntervals,(a,b) ->Integer.compare(a[0],b[0]));

       List<int[]> merged = new ArrayList<>();
       int current[] = occupiedIntervals[0];

       for(int i = 1;i<occupiedIntervals.length;i++){
        int next[] = occupiedIntervals[i];

        if(next[0] <= current[1]+1){
            current[1] = Math.max(next[1],current[1]);
        }else{
            merged.add(current);
            current = next;
        }
       }
       merged.add(current);

       List<List<Integer>> result = new ArrayList<>();

       for(int[] interval : merged){
          int s = interval[0];
          int e = interval[1];

         if(e < freeStart || s > freeEnd){
            addInterval(result,s,e);
         }else{
            if(s < freeStart){
                addInterval(result,s,freeStart-1);
            }

            if(e > freeEnd){
                addInterval(result,freeEnd+1,e);
            }
         }
       }

       return result;
    }

    public void addInterval(List<List<Integer>> list,int start,int end){
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        ans.add(end);
        list.add(ans);
    }
}