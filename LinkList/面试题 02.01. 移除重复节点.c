/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

// 未排序链表
// 当前节点只用和后面节点比较
// 删除节点变种，值变成所有节点的值
struct ListNode* removeDuplicateNodes(struct ListNode* head) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  //   struct ListNode* s = NULL;
  while (head) {
    struct ListNode* cur = head;
    while (cur) {
      if (head->val == cur->next->val) {
        cur = cur->next;
      }
      cur = cur->next;
    }
    head = head->next;
  }
  return pre->next;
}
