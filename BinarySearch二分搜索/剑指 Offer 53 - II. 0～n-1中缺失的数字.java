// 第一个错序的数字，左边界
// 题目理解问题：长度为n-1,如果都不缺失，则缺失n
class Solution {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            // 数比下标大，说明当前或之前有缺失
            if(nums[mid] > mid){
                r = mid - 1;
            }
            else if(nums[mid] <= mid){
                l = mid + 1;
            }
        }
        if(l >= nums.length){
            return nums.length;
        }
        return nums[l]-1;
    }
}
