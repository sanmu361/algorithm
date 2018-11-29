package com.sanmu.algorithm.dp;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-07 13:39
 **/
public class Shares {

    public static void main(String[] args) {

    }

    public static int MaxProfitk(int prices[], int n){
        int[][] dp = new int[n+1][prices.length];
        int i,j,k;

        for(k = 1; k <= n; k++){
            for(i = 1; i < prices.length; i++){
                dp[k][i]  = dp[k][i -1];
                for(j = 0; j < i; j++){
                    dp[k][i] = Math.max(dp[k][i],dp[k - 1][j] + prices[i] - prices[j]);
                }
            }
        }
        return dp[n][prices.length - 1];
    }

    public static int MaxProfitk1(int prices[], int n){
        int[][] dp = new int[n+1][prices.length];
        int i,j,k;

        for(k = 1; k <= n; k++){
            int max = dp[k-1][0] - prices[0];
            for(i = 1; i < prices.length; i++){
                    dp[k][i] = Math.max(dp[k][i],max + prices[i]);
                max = Math.max(max,dp[k-1][i] - prices[i]);
            }
        }
        return dp[n][prices.length - 1];
    }
}
