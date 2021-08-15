/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // null,1,2
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode h = head;
        while(h.next != null){
            ListNode cur = h.next;
            h.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return pre.next;
    }
}

 /*
 p h h.next
 p-1-2------3-4-5

1.next = 2.next;
2.next = p.next;
p.next = 2;

p   h h.next
p-2-1-3-----4-5
1.next = 3.next;
3.next = p.next;
p.next = 3;

p-3-2-1-4-5
*/
