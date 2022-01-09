class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
// 只有a & b = 1时会有进位，(a & b) << 1就是进位值
// 异或^是无进位的加法