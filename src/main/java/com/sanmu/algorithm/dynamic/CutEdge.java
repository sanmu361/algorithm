package com.sanmu.algorithm.dynamic;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-11 15:47
 **/
public class CutEdge {
    static int n, m;
    static int[][] e = new int[9][9];
    static int[] num = new int[9];
    static int[] low = new int[9];
    static int index,root;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                e[i][j] = 0;
            }
        }
        for (int i = 1; i <= m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            e[x][y] = 1;
            e[y][x] = 1;
        }
        root = 1;
        dfs(1, root);
    }

    private static void dfs(int cur, int father) {
        index++;
        num[cur] = index;
        low[cur] = index;
        for (int i = 1; i <= n; i++) {
            if (e[cur][i] == 1) {
                if (num[i] == 0) {
                    dfs(i, cur);
                    low[cur] = Math.min(low[i], low[cur]);
                    if (low[i] > num[cur]) {
                        System.out.println(cur + "-" + i);
                    }
                } else if (i != father) {
                    low[cur] = Math.min(low[cur], num[i]);
                }
            }
        }
    }
}
