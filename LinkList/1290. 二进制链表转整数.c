/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// n进制从高位转10进制
int getDecimalValue(struct ListNode* head) {
  int sum = 0;
  while (head) {
    sum = sum * 2 + head->val;
    head = head->next;
  }
  return sum;
}