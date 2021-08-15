// 倒序：栈，从后遍历
// 双指针拼接
class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim();
        // 线程不安全的，效率高
        StringBuilder sb = new StringBuilder();
        int r = s1.length()-1;
        while(r >= 0){
            int l = r;
            while(l>=0 && s1.charAt(l) != ' '){
                l--;
            }
            // 最后会多一个空格
            sb.append(s1.substring(l+1,r+1) + " ");
            while(l>=0 && s1.charAt(l) == ' '){
                l--;
            }
            r = l;
        }
        return sb.toString().trim();
    }
}
// // 原地反转
// class Solution {
//     public String reverseWords(String s) {
//         // 删除首尾空格并分割字符串
//         // String[] strs = s.trim().split(" ");
//         String s1 = s.trim();
//         char[] tmp = s1.toCharArray();
//         reverseArray(tmp,0,tmp.length-1);
//         // System.out.println(new String(tmp));
//         int r = tmp.length-1;
//         // 从前往后遍历无法获取最后一个单词，从后往前遍历无法获取第一个单词
//         while(r >= 0){
//             int l = r;
//             while(l>=0 && tmp[l] != ' '){
//                 l--;
//             }
//             reverseArray(tmp,l+1,r);
//             while(l>=0 && tmp[l] == ' '){
//                 l--;
//             }
//             r = l;
//         }
//         String a1 = new String(tmp);
//         // 删除空格
//         String a2 = a1.replaceAll(" +", " ");
//         return a2;
//     }
//     public void reverseArray(char[] tmp,int l,int r){
//         while(l < r){
//             char t = tmp[l];
//             tmp[l] = tmp[r];
//             tmp[r] = t;
//             l++;
//             r--;
//         }
//     }
// }
