class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        // 防止边界溢出
        // 分子，分母
        long a = numerator;
        long b = denominator;
        // a，b异号，结果为负数
        if (a > 0 && b < 0 || a < 0 && b > 0){
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        // 整数部分
        sb.append(a/b);
        if (a % b == 0){
            return sb.toString();
        }
        sb.append('.');
        // 小数部分
        Map<Long, Integer> map = new HashMap<>();
        // 模拟竖式除法的运算过程（添0），退出条件是整除或者循环
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            // 存放被除数对应的商的位置
            map.put(a, sb.length());
            sb.append(a / b);
        }
        // 整除
        if (a == 0){
            return sb.toString();
        }
        // 循环，添加（）
        sb.insert(map.get(a).intValue(), '(');
        sb.append(')');
        return sb.toString();
    }
}