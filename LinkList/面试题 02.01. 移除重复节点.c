/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* removeDuplicateNodes(struct ListNode* head) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  struct ListNode* s = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* cur;
  while (head) {
    s = head;
    cur = head->next;
    while (cur) {
      if (head->val == cur->val) {
        s->next = cur->next;
        cur = cur->next;
      } else {
        s = s->next;
        cur = cur->next;
      }
    }
    head = head->next;
  }
  return pre->next;
}