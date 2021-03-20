/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
//前导0
struct ListNode* removeElements(struct ListNode* head, int val) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  while (head) {
    if (head->val == val) {
      head = head->next;
    } else {
      break;
    }
  }
  pre = head;
  //   [1 1 1 2 3 2 2 1] 2
  while (head) {
    struct ListNode* tmp = head;
    while (tmp->next && tmp->next->val == val) {
      tmp = tmp->next;
    }
    head->next = tmp->next;
    head = head->next;
  }
  return pre;
}
//增加头节点指针pre,方便操作
struct ListNode* removeElements(struct ListNode* head, int val) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  struct ListNode* tmp = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  tmp->next = head;
  while (pre->next) {
    if (pre->next->val == val) {
      tmp->next = tmp->next->next;
      tmp = tmp->next;
    }
    pre = pre->next;
  }
  return tmp->next;
}