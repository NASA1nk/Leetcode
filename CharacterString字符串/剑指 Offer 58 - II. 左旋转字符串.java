// 原地翻转
// ba
// gfedc
// cdefgab
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] tmp = s.toCharArray();
        reverseArray(tmp,0,n-1);
        reverseArray(tmp,n,tmp.length-1);
        reverseArray(tmp,0,tmp.length-1);
        return new String(tmp);
    }
    public void reverseArray(char[] tmp,int l,int r){
        while(l < r){
            char t = tmp[l];
            tmp[l] = tmp[r];
            tmp[r] = t;
            l++;
            r--;
        }
    }
}
// 字符串拼接
// class Solution {
//     public String reverseLeftWords(String s, int n) {
//         // String concat
//         String tmp1 = s.substring(0,n);
//         String tmp2 = s.substring(n);
//         String ans = tmp2.concat(tmp1);
//         return ans;
//     }
// }
