class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
   public void push(int x) {
        while (!st1.isEmpty()) {  
            st2.push(st1.pop());  // Move all elements from st1 to st2
        }
        st1.push(x);  // Push the new element to st1
        while (!st2.isEmpty()) {  
            st1.push(st2.pop());  // Move elements back to st1
        }
    }
    
    public int pop() {
        if(st1.size() == 0){
            return -1;
        }
        int rem = st1.peek();
        st1.pop();
        return rem;
    }
    
    public int peek() {
        if(st1.size() == 0){
            return -1;
        }
        int high = st1.peek();
        return high;
    }
    
    public boolean empty() {
        if(st1.size() == 0){
            return true;
        }
        else{return false;}
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