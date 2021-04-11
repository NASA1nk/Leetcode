// n << 1
// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         int[] ans = new int[n*2];
//         int l = 0;
//         for (int i = 0; i < n; i++) {
//             ans[l++] = nums[i];
//             ans[l++] = nums[i+n];
//         }
//         return ans;
//     }
// }

// 空间复杂度为O(1)的做法?
class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while(nums[i] > 0){
                j = j < n ? j*2 : (j-n)*2+1;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                nums[j] = -nums[j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        return nums;
    }
}