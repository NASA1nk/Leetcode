class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        // 数字出现3次对应的二进制的位都是三的倍数
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<32; j++){
                counts[j] += (nums[i]&1);
                nums[i] >>>= 1; 
            }
            
        }
        // 剩下非0的的位就是单独的数字
        // counts对应int的32位，是从低位到高位
        // ans对应数字或的位因为需要左移所以一开始是高位，所以对应31-i
        int ans = 0;
        for(int i=0; i<32; i++){
            ans <<= 1;
            ans |= counts[31-i] % 3;
        }
        return ans;
    }
}
// class Solution {
//     public int singleNumber(int[] nums) {
//         for(int i=0; i<nums.length; i++){
//             int f = 0;
//             for(int j=0; j<nums.length; j++){
//                 if(i == j){
//                     continue;
//                 }
//                 int t = nums[i] ^ nums[j];
//                 if(t == 0){
//                     f++;
//                 }
//             }
//             if(f == 0){
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }