/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        // 前驱
        ListNode hp = pre;
        ListNode h = head;

        while (h != null) {
            ListNode p = pre;
            // 剪枝
            if (h.val >= hp.val) {
                hp = hp.next;
                h = h.next;
                continue;
            }
            while (p.next != null) {
                if (p.next == h) {
                    hp = hp.next;
                    h = h.next;
                    break;
                }
                if (p.next.val >= h.val) {
                    hp.next = h.next;
                    h.next = p.next;
                    p.next = h;
                    h = hp.next;
                    break;
                }
                p = p.next;
            }

        }
        return pre.next;
    }
}
// 65-318724
// 5-6-318724
// 3-56-18724
// 1-356-8724
// 13568-724
// 1356-7-824
// 1-2-356784
// 123 4 5678
// [4,19,14,5,-3,1,8,5,11,15]
// 4 5 14 19 5-3 1 8 5 11 15