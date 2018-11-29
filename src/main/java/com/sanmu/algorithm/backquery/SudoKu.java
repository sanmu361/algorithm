package com.sanmu.algorithm.backquery;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-07 10:51
 **/
public class SudoKu {
    public void solveSudoku(char[][] board) {
        if(board == null||board.length==0)
            return ;
        helper(board);
    }
    private boolean helper(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char num = '1';num<='9';num++){
                        if(isValid(board,i,j,num)){
                            board[i][j]=num;
                            if(helper(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;//全部放过后还是没有正确的
                }
            }
        }
        return true;//全部遍历后找不到有‘.’的，都写完啦，说明对了
    }
    private boolean isValid(char[][] board,int i,int j,char c){
        for(int row=0;row<9;row++){//行是否合法
            if(board[row][j]==c)
                return false;
        }
        for(int col=0;col<9;col++){//列是否合法
            if(board[i][col]==c)
                return false;
        }
        for(int row=i/3*3;row<i/3*3+3;row++){//小的block是否合法
            for(int col=j/3*3;col<j/3*3+3;col++){
                if(board[row][col]==c)
                    return false;
            }
        }
        return true;
    }


}

