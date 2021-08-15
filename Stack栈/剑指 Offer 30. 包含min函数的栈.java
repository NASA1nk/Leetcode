class MinStack {
    // 必须获得次小值
    /** initialize your data structure here. */
    private Deque<Integer> dq1;
    private Deque<Integer> dq2;
    public MinStack() {
        dq1 = new LinkedList<Integer>();
        dq2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        dq1.push(x);
        if(!dq2.isEmpty()){
            if(x > dq2.peek()){
                dq2.push(dq2.peek());
            }
            else{
                dq2.push(x);
            }
        }
        else{
            dq2.push(x);
        }
    }

    public void pop() {
        dq1.pop();
        dq2.pop();
    }

    public int top() {
        return dq1.peek();
    }

    public int min() {
        return dq2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
