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
  pre->next = head;
  int* hash = (int*)malloc(sizeof(int) * 20001);
  struct ListNode* cur;
  while (head) {
    cur = head->next;
    if (hash[head->val] == 0) {
      hash[head->val] = 1;
    } else {
      pre->next = cur->next;
    }
    pre = pre->next;
    head = head->next;
  }
  return pre->next;
}