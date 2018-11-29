package com.sanmu.algorithm.def;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-15 10:21
 **/
public  class Solution {
    int result = 0;
    public int totalNQueens(int n) {

        if(n <= 0){
            return result;
        }

        int[] columnVal = new int[n];

        def(n,0,columnVal);

        return result;

    }

    public void def(int nQueens,int row, int[] columnVal){
        if(row == nQueens){
            this.result++;
        }else{
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i;
                if(isValid(row,columnVal)){
                    def(nQueens,row + 1,columnVal);
                }
            }
        }
    }

    public boolean isValid(int row, int[] columnVal){
        for(int i=0;i<row;i++){
            if(columnVal[row]==columnVal[i] || Math.abs(columnVal[row]-columnVal[i]) == row-i)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.totalNQueens(4));
    }
}