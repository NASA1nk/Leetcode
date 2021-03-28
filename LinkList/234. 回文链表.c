/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

// 快慢指针找中间节点的同时用慢指针反转前半部分链表,再直接与后半比分比较
// while (fast != null && fast.next != null) {
//   fast = fast.next.next;
//   temp = slow.next;
//   slow.next = pre;
//   pre = slow;
//   slow = temp;
// }
// if (fast != null) {
//   slow = slow.next;
// }

// o(1)空间复杂度,快慢指针,反转后半部分再比较
// 奇数长度的中间节点可以认为是前半部分的节点，只比较后半部分长度的节点即可
bool isPalindrome(struct ListNode* head) {
  if (head->next == NULL) {
    return true;
  }
  struct ListNode* l = head;
  int len = 0;
  while (l) {
    len++;
    l = l->next;
  }
  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = head;
  struct ListNode *fast, *slow;
  fast = slow = head;
  while (fast && fast->next) {
    fast = fast->next->next;
    slow = slow->next;
  }
  if (len % 2 == 1) {
    slow = slow->next;
  }
  struct ListNode* mid = (struct ListNode*)malloc(sizeof(struct ListNode));
  mid->next = slow;
  struct ListNode* p = mid;
  struct ListNode* h = slow;
  struct ListNode* cur = h->next;
  while (cur) {
    h->next = cur->next;
    cur->next = p->next;
    p->next = cur;
    cur = h->next;
  }
  for (int i = 0; i < len / 2; i++) {
    if (pre->next->val != p->next->val) {
      return false;
    }
    pre = pre->next;
    p = p->next;
  }
  return true;
}

// 硬写,反转后和自己判断
// 不用存到链表里面，存到数组里即可，数组可以直接从后往前遍历
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
