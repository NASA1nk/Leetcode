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
  //   哨兵节点广泛应用于树和链表中，如伪头、标记等，通常不保存任何数据
  //   其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
  //   伪头
  struct ListNode* s = (struct ListNode*)malloc(sizeof(struct ListNode));
  s->next = head;
  struct ListNode* cur = head;
  struct ListNode* pre = s;
  while (cur) {
    if (cur->val == val) {
      pre->next = cur->next;
    } else {
      pre = cur;
    }
    cur = cur->next;
  }
  return s->next;
}