int numJewelsInStones(char* jewels, char* stones) {
  int lj = strlen(jewels);
  //   A:65,  z:122
  int* hash = (int*)malloc(sizeof(int) * 58);
  memset(hash, 0, sizeof(hash));
  for (int i = 0; i < lj; i++) {
    hash[jewels[i] - 'A'] = 1;
  }
  int ls = strlen(stones);
  int ans = 0;
  for (int i = 0; i < ls; i++) {
    if (hash[stones[i] - 'A'] == 1) {
      ans++;
    }
  }
  return ans;
}