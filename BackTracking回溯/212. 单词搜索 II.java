class Solution {
    List<String> ans = new LinkedList<>();
    public List<String> findWords(char[][] board, String[] words) {
        StringBuilder track = new StringBuilder();
        int[][] vis = new int[board.length][board[0].length];
        int[] did = new int[words.length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                for(int k=0; k<words.length; k++){
                    if(words[k].charAt(0) == board[i][j]){
                        backtracking(board,i,j,words[k],0,track,vis,did,k);
                    }
                }
            }
        }
        return ans;
    }
    public void backtracking(char[][] board,int m,int n,String word,int index,StringBuilder track,int[][] vis,int[] did,int k){
        if(m >= board.length || m < 0 || n >= board[m].length || n < 0){
            return ;
        }
        if(board[m][n] != word.charAt(index) || vis[m][n] == 1 || did[k] == 1){
            return ;
        }
        track.append(board[m][n]);
        if(index == word.length()-1){
            ans.add(track.toString());
            track.deleteCharAt(track.length()-1);
            did[k] = 1;
            return ;
        }
        vis[m][n] = 1;
        backtracking(board,m,n+1,word,index+1,track,vis,did,k);
        backtracking(board,m,n-1,word,index+1,track,vis,did,k);
        backtracking(board,m+1,n,word,index+1,track,vis,did,k);
        backtracking(board,m-1,n,word,index+1,track,vis,did,k);
        vis[m][n] = 0;
        track.deleteCharAt(track.length()-1);
    }
}