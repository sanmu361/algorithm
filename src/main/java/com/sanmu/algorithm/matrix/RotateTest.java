package com.sanmu.algorithm.matrix;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-13 9:53
 **/
public class RotateTest {

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);
        System.out.println(matrix);
    }

    public  static void rotate(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        if(m != n){
            return;
        }

        int[][] result = new int[m][n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                result[j][n - 1 -i] = matrix[i][j];
            }
        }

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
               matrix[i][j] = result[i][j];
            }
        }

    }
}
