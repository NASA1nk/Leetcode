// 最多有i+1个i值（i+1个兔子说自己有i个同伴）
// 不同的值一定是不同的兔子
// 如果有0，则单独是一种兔子
// 1 1 是2
// 2 2 2 是3
int numRabbits(int* answers, int answersSize) {
  int* hash = (int*)malloc(sizeof(int) * 1001);
  memset(hash, 0, 4004);
  int l = -1;
  int ans = 0;
  for (int i = 0; i < answersSize; i++) {
    if (answers[i]) {
      hash[answers[i]]++;
    } else {
      ans++;
    }
    if (answers[i] > l) {
      l = answers[i];
    }
  }
  for (int i = 1; i <= l; i++) {
    if (hash[i]) {
      if (hash[i] <= i + 1) {
        ans += (i + 1);
      } else {
        int x = hash[i] / (i + 1);
        ans += x * (i + 1);
        int y = hash[i] % (i + 1);
        if (y) {
          ans += (i + 1);
        }
      }
    }
  }
  return ans;
}
// [0,3,2,0,3,3,4,2,4,3,2,4,4,3,0,1,3,4,4,3]
// [10,10,10]
// [0,0,0,0]
// [85,398,329,85,85,239,239,459,1,11,3,0,0]
// [1,0,1,0,0]
// []
// [1,1,2]
// [1,2,3,4]
// [1,1,1,1,1]
// [1,2,3,3,3,2,1]