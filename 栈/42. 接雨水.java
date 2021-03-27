import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        s.push(height[0]);
        int ans = 0;
        int tmp = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > s.peek()) {
                tmp = 0;
                while (!s.empty() && height[i] > s.peek()) {
                    tmp += (height[i] - s.peek());
                    s.pop();
                }
                if (s.empty()) {
                    tmp = 0;
                }
            }
            s.push(height[i]);
            ans += tmp;
        }
        return ans;
    }
}
// [9,6,7,4,5]
// [9,4,4,4,5,3,2]
// [1000,5,9,3,2,1]
// [10,4,5,3,2]
// [4,9,4,5,3,2]
// [9,8,7,6]
// [9,2]
// [0,10,9,27,4,8,3,4,7,3,2984,79,2,8,3,4]
// [9,8,7,4,8,5,8,1,9,2]
// [4,3,2,1,2]
// [9,7,8,3,6,4,5]
// [4,2,3]
// [0,1,0,2,1,0,1,3,2,1,2,1]
// [4,2,0,3,2,5]
// [1,1,1]
// [0,1,1]
// [0,23,4,1,23,4,5,6,7,23,2312]