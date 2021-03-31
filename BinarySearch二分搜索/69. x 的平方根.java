class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
          int mid = (left + right) / 2;
          long m = (long)mid * (long)mid;
          if (m < x) {
            int next = mid+1;
            long n = (long)next*(long)next;
            if (n > x) {
              return mid;
            } else if (n == x) {
              return next;
            } else if (n < x) {
              left = mid + 1;
            }
          } else if (m > x) {
            right = mid - 1;
          } else if (m == x) {
            return mid;
          }
        }
        return left;
    }
}