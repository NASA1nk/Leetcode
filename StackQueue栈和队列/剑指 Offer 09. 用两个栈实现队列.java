class CQueue {
    // 第一行表示操作
    // 第二行表示操作的参数
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    public CQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        st1.push(value);
    }

    public int deleteHead() {
        if(!st2.empty()){
            return st2.pop();
        }
        else
        {
            if(st1.empty()){
                return -1;
            }
            else{
                while(!st1.empty()){
                    st2.push(st1.pop());
                }
                return st2.pop();
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
