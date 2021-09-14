// "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"

// "aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa"


// 马拉车
class Solution {
  public String longestPalindrome(String s) {
      if (s.length() == 0 || s.length() == 1)
          return s;
      // 预处理
      char[] t = preTreat(s);
      // 回文半径
      int[] RL = new int[t.length];
      // 记录最右回文串的pos和MaxRight
      int pos = 0;
      int MaxRight = 0;
      // 记录最大回文长度和起始位置
      int ans = 0;
      int index = 0;
      // 第一位是$
      for(int i=1; i<t.length; i++){
          // 先求RL[i]的下界
          if(i < MaxRight){
              RL[i] = Math.min(RL[2*pos-i], MaxRight-i);
          } 
          else{
              RL[i] = t[i] != '#' ? 2 : 1;
          }
          // 再对剩下部分进行中心扩展,求RL[i]
          while(i-RL[i] >= 0 && i+RL[i] < t.length) {
              if(t[i-RL[i]] == t[i+RL[i]]) {
                  RL[i]++;
              }
              else{
                  break;
              }
          }
          // 更新pos和MaxRight
          if (i+RL[i]-1 > MaxRight) {
              pos = i;
              MaxRight = i + RL[i] - 1;
          }
          // 更新最大回文串长度
          if (RL[i]-1 > ans) {
              ans = RL[i] - 1;
              index = i;
          }
      }
      int start = (index-(ans+1))/2;
      return s.substring(start,start+ans);
  }
  public char[] preTreat(String s){
      StringBuilder sb = new StringBuilder();
      sb.append('$');
      sb.append('#');
      for (int i=0; i<s.length(); i++) {
          sb.append(s.charAt(i));
          sb.append('#');
      }
      return sb.toString().toCharArray();
  }
}   

// 常规dp
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() < 2){
//             return s;
//         }
//         // dp[i][j]:i到j是否是回文串(是的话保存长度)
//         int[][] dp = new int[s.length()][s.length()];
//         // base case dp[i][i],dp[i][i+1]
//         for(int i=0; i<dp.length; i++){
//             dp[i][i] = 1;
//         }
//         int length = 1;
//         int start = 0;
//         // 只用考虑对角线以上即可
//         for(int j=1; j<dp.length; j++){
//             for(int i=0; i<j; i++){
//                 if(s.charAt(i) == s.charAt(j)){
//                     // 当子串长度等于2或者等于3的时候，是否是回文由i与j是否相等决定
//                     if(j-i<3){
//                         dp[i][j] = j-i+1;
//                         if(j-i+1 >= length){
//                             length = j-i+1;
//                             start = i;
//                         }
//                         continue;
//                     }
//                     if(dp[i+1][j-1] == 0){
//                         dp[i][j] = 0;
//                     }
//                     else{
//                         dp[i][j] = dp[i+1][j-1]+2;
//                         if(j-i+1 >= length){
//                             length = j-i+1;
//                             start = i;
//                         }
//                     }
//                 }
//                 else{
//                     dp[i][j] = 0;
//                 }
//             }
//         }
//         return s.substring(start,start+length);
//     }
// }

// 中心扩展
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() == 0){
//             return "";
//         }
//         if(s.length() == 1){
//             return s;
//         }
//         // 中心扩展
//         int ans = 0;
//         int index = 0;
//         for(int i=0; i<s.length(); i++){
//             int l = i-1;
//             int r = i+1;
//             int length = 1;
//             while(l>=0 && s.charAt(l) == s.charAt(i)){
//                 length++;
//                 l--;
//             }
//             while(r<s.length() && s.charAt(r) == s.charAt(i)){
//                 length++;
//                 r++;
//             }
//             while(l>=0&&r<s.length() && s.charAt(l) == s.charAt(r))
//             {
//                 length += 2;
//                 l--;
//                 r++;
//             }
//             if(length >= ans){
//                 ans = length;
//                 index = r;
//             }
//         }
//         return s.substring(index-ans,index);
//     }
// }

// 自己想的垃圾dp
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() == 1){
//             return s;
//         }
//         // 回文子串：连续子串+回文
//         // dp[i]:以s.charAt(i)结尾的最长的回文串长度
//         int[] dp = new int[s.length()];
//         Arrays.fill(dp,1);
//         int ans = 1;
//         int index = 0;
//         for(int i=1; i<s.length(); i++){
//             for(int j=0; j<i; j++){
//                 if(s.charAt(i) == s.charAt(j)){
//                     // i-j+1-2
//                     if(i - j - 1 == dp[i-1]){
//                         dp[i] = dp[i-1] + 2;
//                         break;
//                     }
//                     else if(i - j - 1 < dp[i-1]){
//                         if(isVaild(i,j,s)){
//                             dp[i] = i-j+1;
//                             break;
//                         }
//                     }
//                 }
//             }
//             if(s.charAt(i) == s.charAt(i-1)){
//                 if(dp[i] < 2){
//                     dp[i] = 2;
//                 }
//             }
//             if(dp[i] > ans){
//                 ans = dp[i];
//                 index = i;
//             }
//         }
//         return s.substring(index-ans+1,index+1);
//     }
//     public boolean isVaild(int m,int n,String s){
//         for(int i=n+1,j=m-1; i<j; i++,j--){
//             if(s.charAt(i) != s.charAt(j)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }