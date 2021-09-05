class Solution {
  public boolean exist(char[][] board, String word) {
      boolean[][] vis = new boolean[board.length][board[0].length];
      for(int i=0; i<board.length; i++){
          for(int j=0; j<board[i].length; j++){
              if(board[i][j] == word.charAt(0)){
                  if(backtrack(board,i,j,word,0,vis)){
                      return true;
                  }
              }
          }
      }
      return false;
  }
  public boolean backtrack(char[][] board,int m,int n,String word,int l,boolean[][] vis){
      if(m < 0 || m >= board.length || n < 0 || n >= board[m].length || vis[m][n] || board[m][n] != word.charAt(l)){
          return false;
      }
      if(l == word.length()-1){
          return true;
      }
      vis[m][n] = true;
      boolean f = backtrack(board,m,n+1,word,l+1,vis) || backtrack(board,m,n-1,word,l+1,vis) || backtrack(board,m+1,n,word,l+1,vis) || backtrack(board,m-1,n,word,l+1,vis);
      vis[m][n] = false;
      return f;
  }
}

// 笨比
// 因为在递归之前判断字符，所以必须考虑溢出问题，就得写溢出条件
// 如果在递归后判断，则溢出直接返回false即可，不用考虑边界条件 
// class Solution {
//   boolean f = false;
//   public boolean exist(char[][] board, String word) {
//       boolean[][] vis = new boolean[board.length][board[0].length];
//       for(int i=0; i<board.length; i++){
//           for(int j=0; j<board[i].length; j++){
//               if(board[i][j] == word.charAt(0)){
//                   f = backtrack(board,i,j,word,0,vis);
//                   if(f){
//                       return f;
//                   }
//               }
//           }
//       }
//       return f;
//   }
//   public boolean backtrack(char[][] board,int m,int n,String word,int l,boolean[][] vis){
//       if(l == word.length()-1){
//           return true;
//       }
//       boolean f = false;
//       vis[m][n] = true;
//       int row = board.length;
//       int col = board[0].length;
//       if(m+1 < row && !vis[m+1][n] && board[m+1][n] == word.charAt(l+1)){
//           f = backtrack(board, m+1, n, word, l+1,vis); 
//       }
//       if(f == true){
//           return true;
//       }
//       if(m-1>=0 && !vis[m-1][n] && board[m-1][n] == word.charAt(l+1)){
//           f = backtrack(board, m-1, n, word, l+1,vis); 
//       }
//       if(f == true){
//           return true;
//       }
//       if(n+1 < col && !vis[m][n+1] &&  board[m][n+1] == word.charAt(l+1)){
//           f = backtrack(board, m, n+1, word, l+1,vis); 
//       }
//       if(f == true){
//           return true;
//       }
//       if(n-1 >= 0 && !vis[m][n-1] && board[m][n-1] == word.charAt(l+1)){
//           f = backtrack(board, m, n-1, word, l+1,vis); 
//       }
//       if(f == true){
//           return true;
//       }
//       vis[m][n] = false;
//       return false;
//   }
// }

// [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
// "ABCESEEEFS"
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
// "ABCB"
// [["a","a"]]
// "aa"
// [["A","B","C"],["H","G","D"],["I","F","E"]]
// "ABCDEFGHI"
// [["a","b"],["c","d"]]
// "abcd"
// [["a"]]
// "ab"
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
// "ABCCED"
// [["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","b"]]
// "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"