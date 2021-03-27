/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// 移链表长度l时还原(其余的取模运算)
struct ListNode* rotateRight(struct ListNode* head, int k) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* h = head;
  int l = 0;
  while (h) {
    l++;
    pre = pre->next;
    h = h->next;
  }
  if (!l || !(k % l)) {
    return head;
  }
  int newk = k % l;
  pre->next = head;

  struct ListNode* cur = head;
  for (int i = 0; i < l - newk - 1; i++) {
    cur = cur->next;
  }
  head = cur->next;
  cur->next = NULL;
  return head;
}
