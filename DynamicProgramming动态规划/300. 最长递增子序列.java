class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0; i<dp.length; i++){
            // 对于每个nums[i],需要遍历nums[0]~nums[i-1]
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }
        int ans = 0;
        for(int t : dp){
            if(ans < t){
                ans = t;
            }
        }
        return ans;
    }
}
