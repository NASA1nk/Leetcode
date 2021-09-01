class Solution {
  public int translateNum(int num) {
      // 0:"a" 1:"b" 11:"l" 25:"z"
      // 0~25:对应每个英文字母的字符
      // 只有10~19,20~25之间的两位数可以单独对应一个英文字母
      if(num < 10){
          return 1;
      }
      // 2147483648
      int[] nums = new int[10];
      int l = convert(num,nums);
      // dp[i]:到nums[i]时有多少种翻译方法
      int[] dp = new int[l];
      // base case:dp[0] = 1;
      // 倒序
      dp[l-1] = 1;
      if(nums[l-1] == 1){
          dp[l-2] = 2;
      }
      else if(nums[l-1] == 2 && nums[l-2] <= 5){
          dp[l-2] = 2;
      }
      else{
          dp[l-2] = 1;
      }
      // nums[i]和num[i-1]会拆解影响到dp[i-1],所以由dp[i-2]和dp[i-1]推出dp[i]
      for(int i=l-3;i>=0;i--){
          if(nums[i+1] == 1){
              dp[i] = dp[i+1] + dp[i+2];
          }
          else if(nums[i+1] == 2 && nums[i] <= 5){
              dp[i] = dp[i+1] + dp[i+2];
          }
          else{
              dp[i] = dp[i+1];
          }
      }
      return dp[0];
  }
  // 转换
  public int convert(int num,int[] nums){
      int l = 0;
      while(num != 0){
          nums[l++] = num % 10;
          num /= 10; 
      }
      return l;
  }
}