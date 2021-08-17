// [1,2,3,4,5]
// [1,0,1,1,1]
// [1,1,1,0,1]
// 本题允许等于，允许从0开始旋转（相当于未旋转）
// 右侧旋转的部分都比左侧所有数都要小
class Solution {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(numbers[mid] < numbers[r]){
                // numbers[mid]也可能是最小值
                r = mid;
            }
            else if(numbers[mid] > numbers[r]){
                l = mid + 1;
            }
            else if(numbers[mid] == numbers[r]){
                // 无法判断在哪个区间,只能缩小区间
                r--;
            }
        }
        return numbers[l];
    }
}

// o(n)
// class Solution {
//     public int minArray(int[] numbers) {
//         for(int i=0; i<numbers.length-1; i++){
//             if(numbers[i] > numbers[i+1]){
//                 return numbers[i+1];
//             }
//         }
//         return numbers[0];
//     }
// }
