package com.sanmu.algorithm.LinkedList;

import com.google.gson.Gson;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-29 11:47
 **/
public class StudentQueue {

    public static void main(String[] args) {
        System.out.println(solution("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]"));
    }

    private static String solution(String line) {
        // 在此处理单行数据

        Gson gson = new Gson();
        int[][] numbers = gson.fromJson(line,int[][].class);

        //qsort(numbers,0,numbers.length - 1);
        bubblesort(numbers,numbers.length);

        // 返回处理后的结果
        return gson.toJson(numbers);
    }

    private static void qsort(int a[][], int low,int high){
        if(low >= high){
            return;
        }

        int first = low;
        int last = high;
        int[] key = a[first];

        while(first < last){
            int compare = compare(a[last],key);
            while(first < last && (compare== 1 || compare == 0)){
                --last;
                compare = compare(a[last],key);
            }
            a[first] = a[last];

            compare = compare(a[first],key);
            while(first < last && (compare == 0 || compare == -1)){
                ++first;
                compare = compare(a[first],key);
            }
            a[last] = a[first];
        }

        a[first] = key;
        qsort(a,low,first-1);
        qsort(a,first + 1,high);
    }

    private static void bubblesort(int a[][],int n){
        int i, j;
        int [] temp;
        for (j = 0;j < n - 1;j++)
            for (i = 0;i < n - 1 - j;i++)
            {
                if(compare(a[i],a[i + 1]) == 1)
                {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
    }

    private static int compare(int[] a ,int[] b){
        if(a[0] + a[1] > b[0] + b[1]){
            return 1;
        }else if(a[0] + a[1] == b[0] + b[1]){
            if(a[1] == 0){
                return -1;
            }
            if(a[0] > b[0]){
                return 1;
            }else if(a[0] == b[0]){
                return 0;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
