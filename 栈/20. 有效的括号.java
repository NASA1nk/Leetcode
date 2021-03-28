import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> k = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!k.empty()) {
                if ((s.charAt(i) == ')' && k.peek() == '(') || (s.charAt(i) == ']' && k.peek() == '[')
                        || (s.charAt(i) == '}' && k.peek() == '{')) {
                    k.pop();
                } else {
                    k.push(s.charAt(i));
                }
            }
        }
        if (!k.empty()) {
            return false;
        } else {
            return true;
        }

    }
}