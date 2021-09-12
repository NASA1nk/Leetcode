class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        // dp[i][j]:i到j是否是回文串(是的话保存长度)
        int[][] dp = new int[s.length()][s.length()];
        // base case dp[i][i],dp[i][i+1]
        for(int i=0; i<dp.length; i++){
            dp[i][i] = 1;
        }
        int length = 1;
        int start = 0;
        // 只用考虑对角线以上即可
        for(int j=1; j<dp.length; j++){
            for(int i=0; i<j; i++){
                if(s.charAt(i) == s.charAt(j)){
                    // 当子串长度等于2或者等于3的时候，是否是回文由i与j是否相等决定
                    if(j-i<3){
                        dp[i][j] = j-i+1;
                        if(j-i+1 >= length){
                            length = j-i+1;
                            start = i;
                        }
                        continue;
                    }
                    if(dp[i+1][j-1] == 0){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1]+2;
                        if(j-i+1 >= length){
                            length = j-i+1;
                            start = i;
                        }
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return s.substring(start,start+length);
    }
}

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