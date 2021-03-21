/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* reversePrint(struct ListNode* head, int* returnSize) {
  struct ListNode* cur = (struct ListNode*)malloc(sizeof(struct ListNode));
  cur = head;
  int len = 0;
  while (cur) {
    len++;
    cur = cur->next;
  }
  int* ans = (int*)malloc(sizeof(int) * len);
  int i = len - 1;
  while (head) {
    ans[i--] = head->val;
    head = head->next;
  }
  *returnSize = len;
  return ans;
}
