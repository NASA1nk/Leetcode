/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// 判断指针域->next
// 如果相交（同一节点），那么后面肯定是一样的（部分）
// 将第一个链表连到第二个链表尾部，就是判断一个链表是否有环的题
struct ListNode *getIntersectionNode(struct ListNode *headA,
                                     struct ListNode *headB) {
  if (headA == headB) {
    return headA;
  }
  struct ListNode *a = (struct ListNode *)malloc(struct ListNode);
  struct ListNode *b = (struct ListNode *)malloc(struct ListNode);
  a->next = headA;
  b = headB;
  while (b) {
  }
}