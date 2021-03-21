// 因为如果反转溢出一定不是回文数，回文数反转以后一定是它本身，所以一定不会溢出
bool isPalindrome(int x) {
  if (x < 0) {
    return false;
  } else {
    int y = x;
    long long num = 0;
    while (x) {
      int n = x % 10;
      x = x / 10;
      num = num * 10 + n;
    }
    if (y == num) {
      return true;
    } else {
      return false;
    }
  }
}