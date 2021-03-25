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
  struct ListNode* s = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* cur;
