/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// 链表至少包含两个节点
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
// 并没有给具体的链表,用自己删除自己
void deleteNode(struct ListNode* node) {
  node->val = node->next->val;
  node->next = node->next->next;
}