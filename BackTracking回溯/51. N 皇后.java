class Solution {
    List<List<String>> ans = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        // 棋盘集合
        LinkedList<String> track = new LinkedList<>();
        // 棋盘数组
        char[][] map = new char[n][n];
        for(char[] t : map){
            Arrays.fill(t,'.');
        }
        backtrcak(n,0,track,map);
        return ans;
    }
    public void backtrcak(int n, int row, LinkedList<String> track, char[][] map){
        // System.out.println("第"+ row + "层");
        if(row == n){
            // 传拷贝
            // System.out.println("找到一个答案");
            ans.add(new LinkedList(track));
            return ;
        }
        for(int j=0; j<n; j++){
            if(vis(row,j,n,map)){
                // 选择第j列
                map[row][j] = 'Q';
                // System.out.println("(" + row + "," + j + ") 放皇后，继续遍历下一层");
                String tmp = new String(map[row]);
                track.add(tmp);
                // System.out.println("这一层地图是：" + tmp);
                backtrcak(n,row+1,track,map);
                // 撤销选择
                map[row][j] = '.';
                track.removeLast();
                // System.out.println("从第" + (row+1) + "层回溯出来，做另一个选择");
            }
        }
    }
    public boolean vis(int row,int col,int n,char[][] map){
        // 判断同一列
        for(int i=0; i<row; i++){
            if(map[i][col] == 'Q'){
                return false;
            }
        }
        // 判断左斜方
        int i=row-1;
        int j=col-1;
        while(i >= 0 && j >= 0){
            if(map[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        // 判断右斜方
        i=row-1;
        j=col+1;
        while(i >= 0 && j < n){
            if(map[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}