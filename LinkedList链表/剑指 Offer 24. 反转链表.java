/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// 递归
class Solution {
  public ListNode reverseList(ListNode head) {
      // 递归终止条件
      if(head == null || head.next == null){
          return head;
      }
      // 反转next，并接在head前面(指向head)
      ListNode last = reverseList(head.next);
      // last是反转后的头节点，要将反转后的最后一个节点指向head,head.next就是最后那个节点
      head.next.next = head;
      head.next = null;
      return last;
  }
}
/*
p h h.next
p-1-2-3-4-5

1.next = 2.next;
2.next = p.next;
p.next = 2;

p-2-1-3-4-5
1.next = 3.next;
3.next = p.next;
p.next = 3;

p-3-2-1-4-5
*/
// 迭代
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         // null,1,2
//         if(head == null){
//             return head;
//         }
//         ListNode pre = new ListNode();
//         pre.next = head;
//         ListNode h = head;
//         while(h.next != null){
//             ListNode cur = h.next;
//             h.next = cur.next;
//             cur.next = pre.next;
//             pre.next = cur;
//         }
//         return pre.next;
//     }
// }