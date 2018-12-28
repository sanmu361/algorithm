package com.sanmu.algorithm.dynamic;

import org.apache.commons.collections.MapUtils;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-28 11:56
 **/
public class Gupiao {

    public static void main(String[] args) {
        int []a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a,3));
    }

    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0){
            return 0;
        }

        int result = 0;
        int mn = prices[0];

        for(int i  = 1; i < prices.length; i++ ){
            mn = Math.min(mn,prices[i - 1]);
            result = Math.max(result,prices[i] - mn);
        }
        return result;
    }

    public static int maxProfit(int[] prices,int K){
        int[][] dp = new int[K + 1][prices.length];

        int k = 0;
        for(k = 1; k <= K; k++){
            for(int i = 1; i < prices.length; i++){
                dp[k][i] = dp[k][i - 1];
                for(int j = 0; j < i; j++){
                    dp[k][i] = Math.max(dp[k][i],dp[k - 1][j] + prices[i] - prices[j]);
                }
            }
        }
        return dp[K][prices.length - 1];
    }

    public static int maxProfit1(int[] prices,int K){
        int[][] dp = new int[K + 1][prices.length];

        int k = 0;
        int mx ;
        for(k = 1; k <= K; k++){
            mx = dp[k - 1][0] - prices[0];
            for(int i = 1; i < prices.length; i++){
                dp[k][i] = Math.max(dp[k][i - 1],mx + prices[i]);
                mx = Math.max(mx,dp[k - 1][i] - prices[i]);
            }
        }
        return dp[K][prices.length - 1];
    }
}
