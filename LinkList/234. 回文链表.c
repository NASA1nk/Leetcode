/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// 硬写,反转后和自己判断
// bool isPalindrome(struct ListNode* head) {
//   struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
//   pre->next = head;
//   struct ListNode *p, *cur, *h;
//   p = pre;
//   cur = head->next;
//   h = head;
//   struct ListNode* newp = (struct ListNode*)malloc(sizeof(struct ListNode));
//   newp->next = head;
//   struct ListNode* new = newp;
//   while (head) {
//     struct ListNode* tmp = (struct ListNode*)malloc(sizeof(struct ListNode));
//     tmp->val = head->val;
//     tmp->next = NULL;
//     newp->next = tmp;
//     newp = newp->next;
//     head = head->next;
//   }
//   while (cur) {
//     h->next = cur->next;
//     cur->next = p->next;
//     p->next = cur;
//     cur = h->next;
//   }
//   while (new->next) {
//     if (new->next->val != p->next->val) {
//       return false;
//     }
//     p = p->next;
//     new = new->next;
//   }
//   return true;
// }