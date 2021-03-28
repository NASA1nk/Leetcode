/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// pos不作为参数进行传递，仅仅是为了标识链表的实际情况
// 0(1)内存 快慢指针
bool hasCycle(struct ListNode *head) {
  struct ListNode *fast, *slow;
  fast = slow = head;
  bool f = false;
  while (fast && fast->next) {
    slow = slow->next;
    fast = fast->next->next;
    if (fast == slow) {
      f = true;
      break;
    }
  }
  return f;
}