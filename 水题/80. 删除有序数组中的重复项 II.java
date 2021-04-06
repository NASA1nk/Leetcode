class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = -100001;
        int l = 0;
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != cur){
                cur = nums[i];
                nums[l++] = cur;
                f = 1;
            } else {
                if(f == 1){
                    nums[l++] = cur;
                    f = 0;
                }
            }
        }
        return l;
    }
}