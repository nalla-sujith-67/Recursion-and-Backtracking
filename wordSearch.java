// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

class Solution {

    // creating the direction matrices to navigate through the board.
    public int[] r={0,1,0,-1};
    public int[] c={1,0,-1,0};
    boolean f(int row,int col,int m,int n,int index,char[][] board, String word,boolean[][] vis)
    {
        if(index==word.length()) return true;  // if the complete string is found return true.

        if (row < 0 || col < 0 || row >= m || col >= n || vis[row][col] || board[row][col] != word.charAt(index)) // if invalid or the next char is not in sequence return.
        return false;
        
        vis[row][col]=true;

        for(int i=0;i<4;i++)
        {
            int nextrow=row+r[i];
            int nextcol=col+c[i];
            if(f(nextrow,nextcol,m,n,index+1,board,word,vis))// if the string is found it will return true.
            return true;
        }
        vis[row][col] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(f(i,j,m,n,0,board,word,vis))
                return true;
            }
        }
        return false;
    }
}
