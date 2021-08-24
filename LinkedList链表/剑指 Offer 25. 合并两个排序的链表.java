/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 递归
// l1比l2小，下一个节点应该是l1，则return l1，在return之前指定l1的下一个节点应该是l1.next和l2俩链表的合并后的头结点
// l1比l2大，下一个节点应该是l2，则return l2，在return之前指定l2的下一个节点应该是l1和l2.next俩链表的合并后的头结点
// 原地修改
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

// 使用递归合并
// 递归终止条件：某一个链表为空，则接上另一个链表的剩余节点即可
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode p = pre;
        mergeTwoListsiml(l1,l2,pre);
        return p.next;
    }
    public void mergeTwoListsiml(ListNode l1,ListNode l2,ListNode pre){
        if(l1 == null){
            pre.next = l2;
            return;
        }
        if(l2 == null){
            pre.next = l1;
            return;
        }
        if(l1.val < l2.val){
            pre.next = l1;
            pre = pre.next;
            mergeTwoListsiml(l1.next,l2,pre);
        }
        else{
            pre.next = l2;
            pre = pre.next;
            mergeTwoListsiml(l1,l2.next,pre);
        }
    }
}
// 指针直接遍历即可，不用像归并那样判断
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode pre = new ListNode();
//         ListNode p = pre;
//         while(l1 != null && l2 != null){
//             if(l1.val > l2.val){
//                 pre.next = l2;
//                 l2 = l2.next;
//             }
//             else{
//                 pre.next = l1;
//                 l1 = l1.next;
//             }
//             pre = pre.next;
//         }
//         pre.next = l1 == null ? l2:l1;
//         return p.next;
//     }
// }

// 归并排序写法
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode h1 = l1;
//         ListNode h2 = l2;
//         int len1 = 0;
//         while(h1 != null){
//             h1 = h1.next;
//             len1++;
//         }
//         int len2 = 0;
//         while(h2 != null){
//             h2 = h2.next;
//             len2++;
//         }
//         int l = len1 > len2 ? len1 : len2;
//         ListNode pre = new ListNode();
//         ListNode p = pre;
//         while(l1 != null && l2 != null){
//             if(l1.val > l2.val){
//                 pre.next = l2;
//                 l2 = l2.next;
//             }
//             else{
//                 pre.next = l1;
//                 l1 = l1.next;
//             }
//             pre = pre.next;
//         }
//         if(l1 != null){
//             pre.next = l1;
//         }
//         else{
//             pre.next = l2;
//         }
//         return p.next;
//     }
// }
