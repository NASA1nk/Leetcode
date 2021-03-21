/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
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
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  //双指针
  struct ListNode* p = pre;
  struct ListNode* cur = head;
  while (cur) {
    if (cur->val == val) {
      cur = cur->next;
      p->next = cur;

    } else {
      p = p->next;
      cur = cur->next;
    }
  }
  return pre->next;
}