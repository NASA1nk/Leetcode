class Solution {
  public int[] exchange(int[] nums) {
      // 双指针交换
      int l = 0;
      int r = nums.length-1;
      while(l < r){
          // 在内部移动l和r无法限制l<r,所以要加上边界溢出判断
          while(l<nums.length && nums[l] % 2 != 0){
              l++;
          }
          while(r>=0 && nums[r] % 2 != 1){
              r--;
          }
          // 如果因为溢出终止则不交换，直接退出
          if(r > l){
              int t = nums[r];
              nums[r] = nums[l];
              nums[l] = t;
              // 交换后一定不满足条件 
              l++;
              r--;
          }
      }
      return nums;
  }
}