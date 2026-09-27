class Solution {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        solve(num ,target,0,"",0,0);
        return result;
    }

    public void solve(String num,int target,int index,String exp , long val , long prev){
        if(index == num.length()){
            if(val == target){
                result.add(exp);
            }
            return;
        }

         for (int j = index; j < num.length(); j++) {

            if (j > index && num.charAt(index) == '0') {
                break;
            }

            String current = num.substring(index, j + 1);
            long currentValue = Long.parseLong(current);

                // First number
            if (index == 0) {

                solve(
                    num,
                    target,
                    j + 1,
                    current,
                    currentValue,
                    currentValue
                );

            } else {

                // +
                solve(
                    num,
                    target,
                    j + 1,
                    exp + "+" + current,
                    val + currentValue,
                    currentValue
                );

                // -
                solve(
                    num,
                    target,
                    j + 1,
                    exp + "-" + current,
                    val - currentValue,
                    -currentValue
                );

                // *
                solve(
                    num,
                    target,
                    j + 1,
                    exp + "*" + current,
                    val - prev + prev * currentValue,
                    prev * currentValue
                );
            }
        }    
    }
}