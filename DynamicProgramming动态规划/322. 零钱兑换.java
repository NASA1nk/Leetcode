class Solution {
    // 个数i无限制，求最小，总和必须是account
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        // dp[i]：金额i需要最少的硬币个数
        int[]dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            // 对于每个硬币，选或不选
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i){
                    // 选当前硬币
                    if(dp[i-coins[j]]+1 < dp[i]){
                        dp[i] = dp[i-coins[j]]+1;
                    }
                }
            }
        }
        return dp[amount] == (amount+1) ? -1 : dp[amount];
    }
}
