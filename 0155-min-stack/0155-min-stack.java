class MinStack {
    Stack<Integer> st;
    Stack<Integer> minstack;

    public MinStack() {
        st = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minstack.isEmpty() || val <= minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        int popped = st.pop();
        if(popped == minstack.peek()){
            minstack.pop();
        }
    }
    
    public int top() {
        int top = st.peek();
        return top;
    }
    
    public int getMin() {
        int high = minstack.peek();
        return high;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */