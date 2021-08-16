// 类似替换空格,先计算,再移动
// 2. 快慢指针
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                if(fast != slow){
                    nums[slow] = nums[fast];
                    slow++;
                    fast++;
                }
                else{
                    fast++;
                    slow++;
                }
            }
            else{
                fast++;
            }
        }
        return slow;
    }
}

// 1. 样例给了思路,可以交换,再返回length-count
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int count = 0;
//         for(int x : nums){
//             if(x == val){
//                 count++;
//             }
//         }
//         int l = nums.length;
//         for(int i=0; i<nums.length-count; i++){
//             if(nums[i] == val){
//                 // 甚至不用再换过去
//                 l--;
//                 while(nums[l] == val){
//                     l--;
//                 }
//                 nums[i] = nums[l];
//             }
//         }
//         return nums.length-count;
//     }
// }
