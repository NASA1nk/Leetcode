class Solution {
  public int findPeakElement(int[] nums) {
      // nums[-1] = nums[n] = -∞
      // 严格大于左右相邻值
      // nums[i] != nums[i + 1]
      // -2^31 <= nums[i] <= 2^31 - 1
      int l = 0;
      int r = nums.length-1;
      while(l <= r){
          int mid = l + (r-l)/2;
          if(mid+1 == nums.length || (mid+1 < nums.length && nums[mid] > nums[mid+1])){
              if(mid-1 < 0 || (mid-1>=0 && nums[mid] > nums[mid-1])){
                  return mid;
              }
              else{
                  // mid-1可能称为峰值
                  r--;
              }
          }
          else if(mid+1 < nums.length && nums[mid] < nums[mid+1]){
              // mid+1可能成为峰值
              l++;
          }
      }
      return -1;
  }
}