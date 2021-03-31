// 升序排列，有序查找
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left]+nums[right] == target){
                return new int[]{left,right};
            }
            else if(nums[left]+nums[right] < target){
                left++;
            }
            else if(nums[left]+nums[right] > target){
                right--;
            }
        }
        return new int[0];
    }
}