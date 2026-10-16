class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<asteroids.length;i++){
            boolean destroyed = false;
            
            //collision tabhi hogi agr current elemnet -ve hoga and stack ke top pr positive hoga 
            while(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0){
                if(st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }else if(st.peek() == Math.abs(asteroids[i])){
                    st.pop();//equal hone pr dono destroyed
                }

                destroyed = true;
                break;
            }

            if(!destroyed){
                st.push(asteroids[i]);
            }
        }

        int res[] = new int[st.size()];
        for(int i = res.length-1;i>=0;i--){
            res[i] = st.pop();
        }

        return res;
    }
}