class Solution {
    public int removeDuplicates(int[] nums) {
      int cur = -1000000;
      int l = 0;
      for (int i = 0; i < nums.length; i++) {
        if(nums[i]!= cur){
          cur = nums[i];
          nums[l++] = cur;
        } else {
          continue;
        }
      }
      return l;
    }
}