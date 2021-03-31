/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
  struct ListNode *fast, *slow;
  fast = slow = head;
  while (fast && fast->next) {
    slow = slow->next;
    fast = fast->next->next;
    if (slow == fast) {
      fast = head;
      while (fast != slow) {
        fast = fast->next;
        slow = slow->next;
      }
      return slow;
    }
  }
  return NULL;
}