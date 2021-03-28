// 位运算
// 可以让 n与 2^i 进行与运算,当且仅当n的第i位为1时,运算结果不为0
// 默认是32位,可以直接用for
int hammingWeight(uint32_t n) {
  int sum = 0;
  while (n) {
    if (n >> 1 == 1) {
      sum++;
    }
    n = n >> 1;
  }
  return sum;
}