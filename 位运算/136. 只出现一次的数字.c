// 位运算
// 交换律：a ^ b ^ c = a ^ c ^ b
// 任何数和0异或是本身 0 ^ n = n
// 相同的数异或结果是0: n ^ n = 0
int singleNumber(int* nums, int numsSize) {
  int sum = 0;
  for (int i = 0; i < numsSize; i++) {
    sum ^= nums[i];
  }
  return sum;
}