/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 双指针法
// 由于公共节点后面的节点都是相同的，所以只要处理前面的节点
// 只要双方各自走一遍对方前面的节点，就会相遇在公共节点
// 因为公共节点后面的节点是相同的，所以走了一遍对方的前面的节点，那么双方走的长度是相同的
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;
        // 不能使用next==null判断
        while(headA != headB){
            // 如果用next==null判断无交点时会超时
            headA = headA == null? hb : headA.next;
            headB = headB == null? ha : headB.next;
        }
        return headA;
    }
}

// 哈希表
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if(headA == null || headB == null){
//             return null;
//         }
//         if(headA == headB){
//             return headA;
//         }
//         Set<ListNode> t = new HashSet<>();
//         while(headA != null){
//             t.add(headA);
//             headA = headA.next;
//         }
//         while(headB != null){
//             if(t.contains(headB)){
//                 return headB;
//             }
//             else{
//                 headB = headB.next;
//             }
//         }
//         return null;
//     }
// }

// 笨比方法
// 把公共节点之前的链表切成相同长度然后开始遍历
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if(headA == null || headB == null){
//             return null;
//         }
//         if(headA == headB){
//             return headA;
//         }
//         ListNode ha = headA;
//         ListNode hb = headB;
//         int la = 0;
//         while(ha != null){
//             ha = ha.next;
//             la++;
//         }
//         int lb = 0;
//         while(hb != null){
//             hb = hb.next;
//             lb++;
//         }
//         int l = 0;
//         ListNode h1,h2;
//         if(la > lb){
//             l = la-lb;
//             h1 = headA;
//             h2 = headB;
//         }
//         else{
//             l = lb-la;
//             h1 = headB;
//             h2 = headA;
//         }
//         while(l > 0){
//             h1 = h1.next;
//             l--;
//         }
//         while(h1 != null){
//             if(h1 == h2){
//                 return h1;
//             }
//             h1 = h1.next;
//             h2 = h2.next;
//         }
//         return null;
//     }
// }
