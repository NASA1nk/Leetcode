// 改进：不用n[i] 存每一位数字，直接在while中算出来 int reverse(int x) {
char n[32];
int i = 0;
int f = 0;
if (x < 0) {
  if (x == -2147483648) {
    return 0;
  } else {
    x = -x;
    f = 1;
  }
}
while (x) {
  n[i++] = x % 10;
  x = x / 10;
}
int l = i;
long long number = n[0];
for (i = 1; i < l; i++) {
  number = number * 10 + n[i];
  if (number > 2147483647) {
    return 0;
  }
}
if (f == 1) {
  number = -number;
}
return (int)number;
}
