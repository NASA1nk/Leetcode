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
  // 相对于head.next是递归l-1,r-1
  // 当l=1时，变成反转前r个节点
  public ListNode reverseBetween(ListNode head, int left, int right) {
      if(left == 1){
          return reverseN(head,right);
      }
      head.next = reverseBetween(head.next,left-1,right-1);
      return head;
  }
  // 可以把null看成剩余的头节点
  // 利用m=1找到tail
  // 2-3-4-5反转2-3-4 = 4-3-2-5
  // 2(3)-3(2)-4(1)得到反转后要接的节点5，返回4
  // 3接到4后面，3后面接5 = 2(next=3) 4-3-5
  // 2接到3后面，2后面接5 = 4-3-2-5
  // 返回4
  ListNode tail;
  public ListNode reverseN(ListNode head,int m){
      if(m == 1){
          tail = head.next;
          return head;
      }
      ListNode last = reverseN(head.next,m-1);
      head.next.next = head;
      head.next = tail;
      return last;
  }
}