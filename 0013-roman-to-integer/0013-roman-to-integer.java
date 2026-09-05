class Solution {
    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character,Integer> data = new HashMap<>();
        data.put('I' ,1);
        data.put('V',5);
        data.put('X',10);
        data.put('L',50);
        data.put('C',100);
        data.put('D',500);
        data.put('M',1000);

        for(int i=0;i<s.length()-1;i++){
            if(data.get(s.charAt(i)) < data.get(s.charAt(i+1))){
               res = res -data.get(s.charAt(i));
            }else{
                res = res + data.get(s.charAt(i));
            }
        }
        res = res + data.get(s.charAt(s.length()-1));
        return res;
    }
}