package com.sanmu.algorithm.string;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-19 16:31
 **/
public class LCSProblem {

    public static void main(String[] args) {
        //保留空字符串是为了getLength()方法的完整性也可以不保留
        //但是在getLength()方法里面必须额外的初始化c[][]第一个行第一列
//        String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};
//        String[] y = {"", "B", "D", "C", "A", "B", "A"};
//        int[][] b = getLength(x, y);
//        Display(b, x, x.length-1, y.length-1);

        String a = "123abc89";
        String b = "9023abc123";

        System.out.println(getCommonStrLength(a,b));

        System.out.println(getCommonStr(a,b));
    }

    /**
     * @param x
     * @param y
     * @return 返回一个记录决定搜索的方向的数组
     */
    public static int[][] getLength(String[] x, String[] y)
    {
        int[][] b = new int[x.length][y.length];
        int[][] c = new int[x.length][y.length];
        for(int i=1; i<x.length; i++)
        {
            for(int j=1; j<y.length; j++)
            {
                //对应第一个性质
                if( x[i] == y[j])
                {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }
                //对应第二或者第三个性质
                else if(c[i-1][j] >= c[i][j-1])
                {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 0;
                }
                //对应第二或者第三个性质
                else
                {
                    c[i][j] = c[i][j-1];
                    b[i][j] = -1;
                }
            }
        }
        return b;
    }

    private static int getCommonStrLength(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    private static String getCommonStr(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int maxI = 0;
        int maxL = 0;

        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(dp[i][j] > maxL){
                    maxL = dp[i][j];
                    maxI = i;
                }
            }
        }



        return str1.substring(maxI - maxL,maxI);
    }

    /**
     * getLCS TODO :得到最长子序列长度，并输出所有最长子序列
     *
     * @param x
     *            序列x
     * @param y
     *            序列y
     * @return 最长子序列长度
     * @author zhiman
     * @date 2018/04/17 下午9:24:18
     */
    private static int getLCS(String x, String y) {
        int xlen = x.length();
        int ylen = y.length();

        // 此处的棋盘长度要比字符串长度多加1，需要多存储一行0和一列0
        int[][] commonSublen = new int[xlen + 1][ylen + 1];
        // 1代表上 2 代表向左上 3代表向左 4代表上或者左
        int[][] direction = new int[xlen + 1][ylen + 1];
        // 将整个数组commonSublen填充值
        for (int i = 1; i <= xlen; i++) {
            char xi = x.charAt(i - 1);
            for (int j = 1; j <= ylen; j++) {
                char yj = y.charAt(j - 1);
                if (xi == yj) {
                    commonSublen[i][j] = commonSublen[i - 1][j - 1] + 1;
                    // 2 代表向左上
                    direction[i][j] = 2;
                } else if (commonSublen[i - 1][j] > commonSublen[i][j - 1]) {
                    commonSublen[i][j] = commonSublen[i - 1][j];
                    // 1代表上
                    direction[i][j] = 1;
                } else if (commonSublen[i - 1][j] < commonSublen[i][j - 1]) {
                    commonSublen[i][j] = commonSublen[i][j - 1];
                    // 3代表左
                    direction[i][j] = 3;
                } else {
                    // 如果commonSublen[i - 1][j] == commonSublen[i][j - 1]
                    // 向上或者向左不影响结果
                    // 4代表上 或者 左
                    commonSublen[i][j] = commonSublen[i - 1][j];
                    // 1代表上
                    direction[i][j] = 4;
                }
            }
        }

        int maxSublen = commonSublen[xlen][ylen];
        String lcs = "";
        printSublen(commonSublen);
        printAllLcs(direction, x, lcs, maxSublen, xlen, ylen);
        return maxSublen;
    }

    /**
     * printAllLcs TODO :打印所有的最长公共子序列（不止一个）
     *
     * @param direction 方向矩阵
     * @param x
     * @param lcs
     * @param maxSublen
     * @param i
     * @param j
     * @author zhiman
     * @date 2018/04/17 下午10:01:15
     */
    private static void printAllLcs(int[][] direction, String x, String lcs, int maxSublen, int i, int j) {
        if (i == 0 || j == 0) {
            StringBuilder sb = new StringBuilder(lcs);

            lcs = sb.reverse().toString();
            if (lcs.length() == maxSublen) {
                System.out.println(lcs);
            }
            return;
        }
        int dir = direction[i][j];
        switch (dir) {
            case 1:// 表示向上
                printAllLcs(direction,x,lcs,maxSublen,i-1,j);
                break;
            case 2:// 代表向左上
                lcs +=  x.charAt(i-1);
                printAllLcs(direction,x,lcs,maxSublen,i-1,j-1);
                break;
            case 3:// 3代表向左
                printAllLcs(direction,x,lcs,maxSublen,i,j-1);;
                break;
            case 4:// 表示向上 或 代表向左
                // 表示向上
                printAllLcs(direction,x,lcs,maxSublen,i-1,j);
                // 代表向左
                printAllLcs(direction,x,lcs,maxSublen,i,j-1);
                break;
        }
    }

    /**
     * printSublen TODO :打印commonSublen矩阵
     *
     * @param commonSublen
     * @author zhiman
     * @date 2018/04/17 下午9:55:44
     */
    private static void printSublen(int[][] commonSublen) {
        for (int i = 0; i < commonSublen.length; i++) {
            for (int j = 0; j < commonSublen[0].length; j++) {
                System.out.print(commonSublen[i][j] + "\t");
            }
            System.out.println("\n\n");
        }
    }

    //回溯的基本实现，采取递归的方式
    public static void Display(int[][] b, String[] x, int i, int j)
    {
        if(i == 0 || j == 0)
            return;
        if(b[i][j] == 1)
        {
            Display(b, x, i-1, j-1);
            System.out.print(x[i] + " ");
        }
        else if(b[i][j] == 0)
        {
            Display(b, x, i-1, j);
        }
        else if(b[i][j] == -1)
        {
            Display(b, x, i, j-1);
        }
    }
}
