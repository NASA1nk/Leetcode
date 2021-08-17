class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        // 左边界
        while(l <= r){
            // 防止了 left 和 right 太大直接相加导致溢出
            mid = l + (r - l) / 2;
            if(nums[mid] > target){
                r = mid - 1;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] == target){
                // 继续向左搜索
                r = mid - 1;
            }
        }
        int ansl = l;
        // 右边界
        l = 0;
        r = nums.length-1;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(nums[mid] > target){
                r = mid - 1;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] == target){
                l = mid + 1;
            }
        }
        int ansr = r;
        return ansr - ansl + 1;
    }
}

// 1. 二分查找到值再左右遍历
// 左右遍历的最差时间复杂度是o(n)，所以无法保证二分搜索的o(logn)时间复杂度
// class Solution {
//     public int search(int[] nums, int target) {
//         int l = 0;
//         int r = nums.length-1;
//         int ans = 0;
//         while(l <= r){
//             int mid = l + (r - l) / 2;
//             if(nums[mid] == target){
//                 for(int i=mid+1; i<nums.length; i++){
//                     if(nums[i] != target){
//                         break;
//                     }
//                     else{
//                         ans++;
//                     }
//                 }
//                 for(int i=mid-1; i>=0; i--){
//                     if(nums[i] != target){
//                         break;
//                     }
//                     else{
//                         ans++;
//                     }
//                 }
//                 ans++;
//                 break;
//             }
//             else if(nums[mid] < target){
//                 l = mid+1;
//             }
//             else if(nums[mid] > target){
//                 r = mid-1;
//             }
//         }
//         return ans;
//     }
// }
