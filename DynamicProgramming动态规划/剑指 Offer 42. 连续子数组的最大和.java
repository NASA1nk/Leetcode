class Solution {
  public int maxSubArray(int[] nums) {
      if(nums.length == 0){
          return 0;
      }
      // dp[i]:以nums[i]结尾的最大子数组的和
      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      int ans = dp[0];
      for(int i=1; i<dp.length; i++){
          dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
          ans = Math.max(ans,dp[i]);
      }
      return ans;
  }
}