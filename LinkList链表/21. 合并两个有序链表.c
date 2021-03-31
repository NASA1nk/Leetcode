/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// 合并链表，直接指向链表即可
// 合并后最多只有一个未被合并完，直接将链表末尾指向未合并完的链表即可
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
  struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
  struct ListNode* tail = head;
  while (l2 && l1) {
    if (l1->val <= l2->val) {
      tail->next = l1;
      l1 = l1->next;
    } else {
      tail->next = l2;
      l2 = l2->next;
    }
    tail = tail->next;
  }
  tail->next = l1 ? l1 : l2;
  return head->next;
}