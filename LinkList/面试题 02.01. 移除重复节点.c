/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

// 未排序链表-hash(链表元素在[0, 20000]范围内)
// 203删除节点变种，单值变成所有节点的值
struct ListNode* removeDuplicateNodes(struct ListNode* head) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  struct ListNode* s = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* cur;
  while (head) {
    s = head;
    cur = head->next;
    while (cur) {
      if (head->val == cur->val) {
        s->next = cur->next;
        cur = cur->next;
      } else {
        s = s->next;
        cur = cur->next;
      }
    }
    head = head->next;
  }
  return pre->next;
}
