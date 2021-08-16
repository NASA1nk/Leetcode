// Java不推荐用栈，而是用双端队列
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        // Character类型
        Stack<Character> k = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!k.empty()) {
                if ((s.charAt(i) == ')' && k.peek() == '(') || (s.charAt(i) == ']' && k.peek() == '[')
                        || (s.charAt(i) == '}' && k.peek() == '{')) {
                    k.pop();
                    continue;
                }
            }
            k.push(s.charAt(i));
        }
        if (!k.empty()) {
            return false;
        } else {
            return true;
        }

    }
}