/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
//同时指向NULL也是相等
struct ListNode *getIntersectionNode(struct ListNode *headA,
                                     struct ListNode *headB) {
  struct ListNode *prea = headA;
  struct ListNode *preb = headB;
  while (prea != preb) {
    prea = prea ? prea->next : headB;
    preb = preb ? preb->next : headA;
  }
  return prea;
}
