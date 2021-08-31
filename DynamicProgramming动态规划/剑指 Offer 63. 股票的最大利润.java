class Solution {
  public int maxProfit(int[] prices) {
      if(prices.length < 2){
          return 0;
      }
      // 记录前i-1个数中的最小金额
      int minn = prices[0];
      int ans = 0;
      for(int i=1; i<prices.length;i++){
          if(prices[i-1] < minn){
             minn = prices[i-1];
          }
          int t = prices[i] - minn;
          if(t > ans){
              ans = t ;
          }
      }
      return ans;
  }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         if(prices.length == 0){
//             return 0;
//         }
//         // 只有一次,递增子序列最大差
//         // dp[i]是在第i天卖的利润,找到max(dp[i])
//         int[] dp = new int[prices.length];
//         int ans = 0;
//         for(int i=1; i<dp.length; i++){
//             for(int j=0; j<i; j++){
//                 if(prices[i] > prices[j]){
//                     dp[i] = dp[j] + (prices[i] - prices[j]);
//                 }
//             }
//             if(dp[i] > ans){
//                 ans = dp[i];
//             }
//         }
//         return ans;
//         // 爆内存
//         // dp[i][j]是在第i天买,第j天卖的利润,找到max(dp[i][j])
//         // int[][] dp = new int[prices.length-1][prices.length];
//         // int ans = 0;
//         // for(int i=0; i<prices.length-1; i++){
//         //     for(int j=i+1; j<prices.length; j++){
//         //         if(prices[j] > prices[j-1]){
//         //             dp[i][j] = prices[j]-prices[i];
//         //         }
//         //         else{
//         //             dp[i][j] = dp[i][j-1];
//         //         }
//         //         if(dp[i][j] > ans){
//         //             ans = dp[i][j];
//         //         }
//         //     }
//         // }
//         // return ans;
//     }
// }

// // 暴搜
// class Solution {
//     public int maxProfit(int[] prices) {
//         int ans = 0;
//         for(int i=0; i<prices.length; i++){
//             for(int j=0; j<i; j++){
//                 if(prices[i] - prices[j] > ans){
//                     ans = prices[i] - prices[j];
//                 }
//             }
//         }
//         return ans;       
//     }
// }