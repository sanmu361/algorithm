package com.sanmu.algorithm.数学;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-21 10:59
 **/
public class Test {

    public static void main(String[] args) {


//        System.out.println(amount(18D,9D));
//
//        System.out.println(uniquePaths(10,10));

        List<Integer> list = new ArrayList<Integer>();

//        for(int i = 0; i 《)

        int[] b = {9,3,15,20,7};

        StringBuilder stringBuilder = new StringBuilder();

//        System.out.println(Arrays.copyOfRange());
    }

    public static int uniquePaths(int m1, int n1) {
        if(m1 == 0 || n1 == 0){
            return Math.max(m1,n1);
        }

        int m = Math.min(m1 - 1,n1 - 1);
        int n = m1 + n1 - 2;

        return amount(n,m);

    }


    public static int amount(int a,int b) {
        double da=1;
        double xiao=1;
        for(int i=0;i<b;i++) {
            da=da*a;
            a--;
        }
        for(;b>0;b--) {
            xiao=xiao*b;
        }
        return Double.valueOf(da/xiao).intValue();
    }

    public static double amount(double a,double b) {
        double da=1;
        double xiao=1;
        for(int i=0;i<b;i++) {
            da=da*a;
            a--;
        }
        for(;b>0;b--) {
            xiao=xiao*b;
        }
        return da/xiao;
    }

}
