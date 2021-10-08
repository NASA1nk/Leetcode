class Solution {
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        // dp[n][m]长度为n的绳子分为m段的最大值(n>1,m>1)
        // dp[n][n]存放最大值
        int[][] dp = new int[n+1][n+1];
        // base case
        dp[2][2] = 2;
        dp[3][3] = 3;
        for(int i=4; i<=n; i++){
            dp[i][i] = 2;
            for(int j=2; j<=i-1; j++){
                int t = j*dp[i-j][i-j];
                if(t >= dp[i][i]){
                    dp[i][i] = t;
                }
            }
        }
        return dp[n][n];
    }
}