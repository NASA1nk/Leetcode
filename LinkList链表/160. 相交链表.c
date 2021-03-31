/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

// 如果相交（同一节点），那么后面肯定是一样的，因为所有的指针域必须跑完，这时候(尾对齐)就可以用快慢指针
// 快慢指针的写法
// 将第一个链表连到第二个链表尾部，就是判断一个链表是否有环的题
// 要求 O(n) 时间复杂度，且仅用 O(1)
// 内存，返回结果后，两个链表仍须保持原有的结构
struct ListNode *getIntersectionNode(struct ListNode *headA,
                                     struct ListNode *headB) {
  struct ListNode *ha = headA;
  struct ListNode *hb = headB;
  int lenA = 0;
  int lenB = 0;
  while (ha) {
    lenA++;
    ha = ha->next;
  }
  while (hb) {
    lenB++;
    hb = hb->next;
  }
  struct ListNode *prel;
  struct ListNode *pres;
  int len = lenA >= lenB ? lenA - lenB : lenB - lenA;
  prel = lenA >= lenB ? headA : headB;
  pres = lenA >= lenB ? headB : headA;
  while (len--) {
    prel = prel->next;
  }
  int f = 0;
  while (pres) {
    if (pres == prel) {
      f = 1;
      break;
    }
    prel = prel->next;
    pres = pres->next;
  }
  if (f == 1) {
    return pres;
  } else {
    return NULL;
  }
}

// 2
// [1,2]
// [2]
// 1
// 0
// 0
// [1,3]
// []
// 2
// 0
// 0
// [1]
// []
// 1
// 0
// 2
// [0,9,1,2,4]
// [3,2,4]
// 3
// 1
// 8
// [4,1,8,4,5]
// [5,0,1,8,4,5]
// 2
// 3