/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* mergeInBetween(struct ListNode* list1, int a, int b,
                                struct ListNode* list2) {
  struct ListNode *prea, *preb;
  prea = preb = list1;

  while (b--) {
    preb = preb->next;
  }
  preb = preb->next;

  while (a > 1) {
    prea = prea->next;
    a--;
  }
  prea->next = list2;

  struct ListNode* pre = (struct ListNode*)malloc(sizeof(struct ListNode));
  pre->next = list2;
  while (pre) {
    if (pre->next == NULL) {
      pre->next = preb;
      break;
    }
    pre = pre->next;
  }
  return list1;
}