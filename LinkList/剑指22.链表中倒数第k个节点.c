/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* getKthFromEnd(struct ListNode* head, int k) {
  struct ListNode* cur = head;
  int len = 0;
  while (cur) {
    len++;
    cur = cur->next;
  }
  //正数 +1
  int ans = len - k + 1;
  len = 0;
  while (head) {
    len++;
    if (len == ans) {
      break;
    }
    head = head->next;
  }
  return head;
}