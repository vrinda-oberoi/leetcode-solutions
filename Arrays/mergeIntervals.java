/*Problem: Merge Intervals
Platform: LeetCode  56
Difficulty: Medium
Date: 7 March 2026
Topic: Arrays / Intervals
*/



import java.util.*;
class mergeIntervals{
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        //sort the intervals on the basis of starting value
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        //make a list to store the final result
        List <int[]> result  = new ArrayList<>();

        result.add(intervals[0]);

        for(int i=1;i<n;i++){
            int lastInterval[] = result.get(result.size()-1);

            //check ifoverlapping occur or not
            if(lastInterval[1] >= intervals[i][0] &&  lastInterval[1] <= intervals[i][1]){
                lastInterval[1] = intervals[i][1];
            }else if(lastInterval[1] < intervals[i][0]){
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}