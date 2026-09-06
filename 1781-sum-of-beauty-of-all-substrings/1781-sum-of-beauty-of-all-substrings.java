class Solution {
    public int beautySum(String s) {
        int sum = 0;
       
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> map = new HashMap<>();
            
            for(int j=i;j<s.length();j++){
               map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

               int maxi = Integer.MIN_VALUE;
               int mini = Integer.MAX_VALUE;

               for(int val:map.values()){
                maxi = Math.max(maxi,val);
                mini = Math.min(mini,val);
               }

               sum += (maxi-mini);
            }
        }
        return sum;
    }
}