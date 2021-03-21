class Solution {
 public int reverse(int x) {
    int sum = 0;
    while (x!=0) {
      if (sum * 10 / 10 != sum) {
       return 0;
      }
      sum = sum * 10 + x % 10;
      x = x / 10;
    }
    if (x >= 0) {
      return sum;
    } else {
      return -sum;
    }
  }
}