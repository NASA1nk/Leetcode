 class Solution {
     public int findRepeatNumber(int[] nums) {
         // 没有重复值，数组值=下标
         int ans = 0;
         boolean f = false;
         for(int i=0; i<nums.length; i++){
             while(nums[i] != i){
                 if(nums[i] != nums[nums[i]]){
                     int tmp = nums[i];
                     nums[i] = nums[tmp];
                     nums[tmp] = tmp;
                 }
                 else {
                     return nums[i];
                 }
             }
         }
         return -1;
     }
 }
