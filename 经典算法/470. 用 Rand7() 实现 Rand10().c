// The rand7() API is already defined for you.
// int rand7();
// @return a random integer in the range 1 to 7

// 小范围数生成大范围数,考虑多次生成小数通过运算得到大数,问题是组合会造成概率不等,如何解决
// 规律:
// 1.randN()可以等概率的生成[1, N]范围的随机数
// 那么(randX() - 1) × Y + randY() 可以等概率的生成[1, X*Y]范围的随机数
// 即实现了randXY()
// 2.由randN()实现randn(), 其中N是n的倍数,取余+1即可
// randn() = randN()%n+1

// 那么大范围数生成小范围数呢?
// 通过计算,调用randN()生成符合小区间的数即可

// 优化:
// 拒绝采样中的拒绝数可以继续用来生成符合的随机数,拒绝数也相当于一个randm()
// 最终如果拒绝值为1个的时候就可以在下一次肯定可以返回了

int rand10() {
  while (true) {
    int ans = (rand7() - 1) * 7 + rand7();
    if (ans <= 40) {
      return ans % 10 + 1;
    }

    ans = (ans - 40 - 1) * 7 + rand7();
    if (ans <= 60) {
      return ans % 10 + 1;
    }

    ans = (ans - 60 - 1) * 7 + rand7();
    if (ans <= 20) {
      return ans % 10 + 1;
    }
  }
}