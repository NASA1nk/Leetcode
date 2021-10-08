class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> st = new LinkedList<>();
        int l = 0;
        for(int i=0; i<pushed.length; i++){
            st.offerLast(pushed[i]);
            while(!st.isEmpty()){
                if(popped[l] == st.peekLast()){
                    st.pollLast();
                    l++;
                }
                else{
                    break;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}