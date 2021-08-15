/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
//递归
struct ListNode* reverseList(struct ListNode* head) {
  struct ListNode* last = (struct ListNode*)malloc(sizeof(struct ListNode));
  if (head == NULL || head->next == NULL) {
    return head;
  }
  last = reverseList(head->next);
  head->next->next = head;
  head->next = NULL;
  return last;
}
//迭代
//  1→2→3→∅,∅←1←2←3
struct ListNode* reverseList(struct ListNode* head) {
  if (head == NULL || head->next == NULL) {
    return head;
  }
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* cur = head->next;
  struct ListNode* p = head;
  while (cur) {
    p->next = cur->next;
    cur->next = pre->next;
    pre->next = cur;
    cur = p->next;
  }
  return pre->next;
}
