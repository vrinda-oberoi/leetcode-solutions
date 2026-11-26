class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        boolean win = true;
        int left = n-10;
        int req = 9;

        while(req <= left){
            if(win){
             win = false;
            }else{
                win = true;
            }

            left = left - req;
            req = req-1;
        }

        return win;
        
    } 
}