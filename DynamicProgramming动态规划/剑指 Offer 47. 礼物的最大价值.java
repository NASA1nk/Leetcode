class Solution {
    public int maxValue(int[][] grid) {
        // dp[i][j]:到(i,j)格获得的最大价值,求dp[n][n]
        // 每次向右或者向下移动一格: [i][j]到[i][j+1]或[i+1][j]
        // 所以[i][j]需要找[i-1][j]或[i][j-1]
        int[][] dp = new int[grid.length][grid[0].length];
        // base case:dp[0][j],dp[i][0]
        dp[0][0] = grid[0][0];
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for(int i=1; i<dp.length; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        // 状态转移
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                dp[i][j] = grid[i][j] + Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}