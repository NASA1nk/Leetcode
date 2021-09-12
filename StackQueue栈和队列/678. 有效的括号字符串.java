// 直接存字符，无法判断(和*的位置，所以需要再反向遍历一次
// 可以存下标来判断位置
class Solution {
    public boolean checkValidString(String s) {
        LinkedList<Character> st = new LinkedList<>();
        // 只要左边有*就可以匹配),只要右边有*就可以匹配(
        int star = 0;
        for(int i=0; i<s.length(); i++){
            if(st.isEmpty()){
                if(s.charAt(i) == ')'){
                    if(star == 0){
                        return false;
                    }
                    else{
                        star--;
                    }
                }
                else if(s.charAt(i) == '*'){
                    star++;
                }
                else{
                    st.offer(s.charAt(i));
                }
                continue;
            }
            if(s.charAt(i) == '('){
                st.offer(s.charAt(i));
            }
            else if(s.charAt(i) == '*'){
                star++;
            }
            else{
                if(st.peek() == '('){
                    st.poll();
                }
            }
        }
        // 不能只看*的位置，还要判断*的位置
        int t = 0;
        while(!st.isEmpty()){
            t++;
            st.poll();
        }
        if(t > star){
            return false;
        }
        star = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(st.isEmpty()){
                if(s.charAt(i) == '('){
                    if(star == 0){
                        return false;
                    }
                    else{
                        star--;
                    }
                }
                else if(s.charAt(i) == '*'){
                    star++;
                }
                else{
                    st.offer(s.charAt(i));
                }
                continue;
            }
            if(s.charAt(i) == '('){
                if(st.peek() == ')'){
                    st.poll();
                }
            }
            else if(s.charAt(i) == '*'){
                star++;
            }
            else{
                st.offer(s.charAt(i));
            }
        }
        t = 0;
        while(!st.isEmpty()){
            t++;
            st.poll();
        }
        if(t > star){
            return false;
        }
        return true;
    }
}