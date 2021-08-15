/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//  倒序，栈，递归
class Solution {
    public int[] reversePrint(ListNode head) {
        // 如果传入的是ListNode类型，最后就是pop().val
        Deque<Integer> st = new LinkedList<Integer>();
        while(head != null){
            st.push(head.val);
            head = head.next;
        }
        int[] ans = new int[st.size()];
        int l = 0;
        while(!st.isEmpty()){
            ans[l++] = st.pop();
        }
        return ans;
    }
}
