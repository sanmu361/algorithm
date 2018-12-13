package com.sanmu.algorithm.list;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-10 10:36
 **/
public class MerageTest {
    public static void main(String[] args) {
        int two = Integer.parseInt("110", 2); // 2进制
        int eight = Integer.parseInt("11", 2);// 8进制
        System.out.println("二进制转为十进制: " + two);
        System.out.println("八进制转为十进制: " + eight);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            return;
        }
        if(n == 0){
            return;
        }

        int[] result = new int[m + n];
        int i = 0,j = 0;

        while( i < m && j < n){
            if(nums1[i] > nums2[j]){
                result[i + j] = nums2[j];
                j++;
            }else if(nums1[i] < nums2[j]){
                result[i + j] = nums1[i];
                i++;
            }else{
                result[i + j] = nums1[i++];
                result[i + j] = nums2[j++];
            }
        }

        while(i < m){
            result[i + j] = nums1[i++];
        }
        while(j < n){
            result[i + j] = nums2[j++];
        }

        for(int k = 0; k < m + n; k++){
            nums1[k] = result[k];
        }
    }
}
