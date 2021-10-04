class Solution {
    // 相同的数异或等于0
    // 0和任何数异或等于这个数本身
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        // 得到x^y
        for(int i=0; i<nums.length; i++){
            sum ^= nums[i];
        }
        int t = 1;
        // 找到x,y第一个不同的位，不同的位异或为1
        while((sum & t) == 0){
            t <<= 1;
        }
        // 根据不同的位将数组划分，其他的数的这个位上要么是1，要么是0，并且相同的数一定会分到同一组
        int x = 0;
        int y = 0;
        for(int i=0; i<nums.length; i++){
            if((t & nums[i]) == 0){
                x ^= nums[i];
            }
            else{
                y ^= nums[i];
            }
        }
        return new int[]{x,y};
    }
}