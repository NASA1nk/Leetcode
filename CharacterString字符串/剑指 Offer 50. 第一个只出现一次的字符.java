// 2. 数组模拟
// 长度只要能包含所有字符即可，26，以ascii码对应下标存储（s.charAt(i) -'a'）

// 1. LinkedHashMap：使用双向链表（before,after）维护添加元素的顺序
// char的包装类：Character  2个字节
// getOrDefault：没有就返回设置的默认值defaultValue
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> m = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            if(m.get(s.charAt(i)) == null){
                m.put(s.charAt(i),1);
            }
            else{
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            }
        }
        for(Character t : m.keySet()){
            if(m.get(t) == 1){
                return t.charValue();
            }
        }
        return ' ';
    }
}
