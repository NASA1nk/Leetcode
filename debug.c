#include <stdio.h>
#include <stdlib.h>
struct ListNode {
  int val;
  struct ListNode *next;
};
struct ListNode *removeDuplicateNodes(struct ListNode *head) {
  struct ListNode *pre = (struct ListNode *)malloc(sizeof(struct ListNode));
  pre->next = head;
  //   struct ListNode* s = NULL;
  while (head) {
    struct ListNode *cur = head;
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

struct ListNode *createlinklist(int *a, int n) {
  struct ListNode *head = (struct ListNode *)malloc(sizeof(struct ListNode));
  //创建p结点用于记录链表尾结点,相当于一个别名操作head,不用分配空间
  struct ListNode *p;
  //头结点指针初始化
  head->next = NULL;
  p = head;
  for (int i = 0; i < n; i++)  //循环创建结点
  {
    //创建s结点并分配内存
    struct ListNode *s = (struct ListNode *)malloc(sizeof(struct ListNode));
    s->val = a[i];  //给s结点赋值。
    p->next = s;
    s->next = NULL;  //让插在尾部的s结点的指针指向NULL
    p = s;
  }
  return head;
}
int main() {
  int a[6] = {1, 2, 3, 3, 2, 1};
  struct ListNode *p = createlinklist(a, 6);
  struct ListNode *node = removeDuplicateNodes(p->next);
  return 0;
}
