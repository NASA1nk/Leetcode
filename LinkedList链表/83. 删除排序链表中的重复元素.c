/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// 按升序排列，只出现一次
struct ListNode* deleteDuplicates(struct ListNode* head) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* cur;
  while (head) {
    cur = head->next;
    while (cur && cur->val == head->val) {
      cur = cur->next;
    }
    head->next = cur;
    head = head->next;
  }
  return pre->next;
}