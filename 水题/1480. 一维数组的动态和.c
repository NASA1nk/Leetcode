/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* runningSum(int* nums, int numsSize, int* returnSize) {
  int* ans = (int*)malloc(sizeof(int) * numsSize);
  int tmp = 0;
  for (int i = 0; i < numsSize; i++) {
    tmp += nums[i];
    ans[i] = tmp;
  }
  *returnSize = numsSize;
  return ans;
}