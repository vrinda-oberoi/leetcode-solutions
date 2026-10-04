class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while(s1.size()>0){
            s2.push(s1.pop());
        }

        s1.push(x);

        while(s2.size() > 0){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        if(s1.size() == 0){
            return -1;
        }

        int val = s1.pop();
        return val;
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */