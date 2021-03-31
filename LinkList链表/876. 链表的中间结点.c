/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* middleNode(struct ListNode* head) {
  struct ListNode* p = head;
  int len = 0;
  while (p) {
    len++;
    p = p->next;
  }
  len = len / 2;
  while (len--) {
    head = head->next;
  }
  return head;
}
//快慢指针
//有可能 fast->就是NULL了,此时fast->next->next会报错
struct ListNode* middleNode(struct ListNode* head) {
  struct ListNode* fast = head;
  struct ListNode* slow = head;
  while (fast && fast->next) {
    fast = fast->next->next;
    slow = slow->next;
  }
  return slow;
}