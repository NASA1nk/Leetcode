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

// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode pre = new ListNode();
//         pre.next = head;
//         ListNode p = pre;
//         while (head != null && head.next != null) {
//             ListNode h = head;
//             ListNode cur = head.next;
//             h.next = cur.next;
//             cur.next = p.next;
//             p.next = cur;
//             p = h;
//             head = head.next;       
//         }
//         return pre.next;
//     }
// }

// 递归
// 子问题：后面的节点也是一条链表，并且规模比原来的链表小
// 1.反转本条链表的前2个节点,并将子链表看成第三个节点
// 2.递归
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 递归终止条件 base case   (迭代的特判)
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode last = swapPairs(next.next);
        // 递归返回后操作
        head.next = last;
        next.next = head; 
        return next;
    }
}
