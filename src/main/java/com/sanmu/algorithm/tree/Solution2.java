package com.sanmu.algorithm.tree;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-07 11:53
 **/
public class Solution2 {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        boolean guiji[][] = new boolean[grid.length][grid[0].length];
        int result = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!guiji[i][j] && grid[i][j] == '1'){
                    df(guiji,grid,i,j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void df(boolean[][] guiji,char[][] grid,int i, int j){
        if(i < 0 || i == guiji.length || j < 0 || j == guiji[0].length || guiji[i][j] || grid[i][j] == 0){
            return;
        }
        guiji[i][j] = true;
        df(guiji,grid,i-1,j);
        df(guiji,grid,i+1,j);
        df(guiji,grid,i,j-1);
        df(guiji,grid,i,j+1);
    }

}
