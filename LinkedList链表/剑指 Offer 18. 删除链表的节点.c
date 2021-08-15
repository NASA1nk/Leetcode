/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
//删除:找到 n-1
struct ListNode* deleteNode(struct ListNode* head, int val) {
  if (head->val == val) {
    return head->next;
  }
  struct ListNode* pre = head;
  while (head) {
    if (head->next && head->next->val == val) {
      head->next = head->next->next;
      break;
    }
    head = head->next;
  }
  return pre;
}
//存在值相同,加 pre统一操作（原题 203）
//哨兵指针
struct ListNode* deleteNode(struct ListNode* head, int val) {
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode* p = pre;
  struct ListNode* cur = head;
  while (cur) {
    if (cur->val == val) {
      cur = cur->next;
      p->next = cur;
    } else {
      cur = cur->next;
      p = p->next;
    }
  }
  return pre->next;
}