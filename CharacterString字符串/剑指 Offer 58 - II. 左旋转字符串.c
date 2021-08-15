// 经典解法:三次反转
char* reverseLeftWords(char* s, int n) {
  int len = strlen(s);
  if (n >= len) {
    return s;
  }
  while (n--) {
    int tmp = s[0];
    for (int i = 1; i < len; i++) {
      s[i - 1] = s[i];
    }
    s[len - 1] = tmp;
  }
  return s;
}