package com.sanmu.algorithm.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-21 10:09
 **/
public class BinarySearch {

    public static void main(String[] args) {
//        int A[] = new int[]{1,3};
//        int B[] = new int[]{2,4};
//
//        Arrays.asList(A);
//        Map<String,Object> map = new HashMap<>();
//
//        System.out.println(findMedianSortedArrays(A,B));

        int nums[] ={0,1,2,3,4,5,4,3,2};

        System.out.println(binarySerach(nums));

    }

    private static String solution(String line) {
        // 在此处理单行数据
        String strs[] = line.split(" ");
        String nums[] = strs[0].split(",");

        int left =0,right = nums.length - 1,mid;
        while(left + 1 < right){
            mid = (left + right) / 2;
            int result = strs[1].compareTo(nums[mid]);
            if(result == 1){
                left = mid + 1;
            }else if(result == -1){
                right = mid - 1;
            }else{
                return String.valueOf(mid);
            }
        }

        // 返回处理后的结果
        return "-1";
    }

    private int binarySerach(int[] array, int key){
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(array[mid] == key){
                return mid;
            }else if(array[mid] < key){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private static int binarySerach(int[] array){
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if((mid > 0 && array[mid] > array[mid - 1]) && (mid < array.length - 1 && array[mid] < array[mid + 1])){
                left = mid + 1;
            }else if((mid > 0 && array[mid] < array[mid - 1]) && (mid < array.length - 1 &&  array[mid] > array[mid + 1])){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 1 查找第一个与target相等的元素
     *
     * @param arrs
     * @param target
     * @return
     */
    public static int findFirstEqual(int[] arrs, int target) {
        int low = 0;
        int high = arrs.length - 1;
        int m = 0;

        while(low <= high) {
            m = low + (high - low) / 2;
            //只要target小于等于就往左移
            if(arrs[m] >= target) {
                high = m - 1;
            } else {
                low = m +1;
            }
        }
        if(low < arrs.length && arrs[low] == target) {
            return low;
        }
        return -1;
    }

    /**
     * 2 查找最后一个与target相等的元素
     *
     * @param arrs
     * @param target
     * @return
     */
    public static int findLastEqual(int[] arrs, int target) {
        int low = 0;
        int high = arrs.length - 1;
        int m = 0;

        while(low <= high) {
            m = low + (high - low) / 2;
            //只要target小于等于就往右移
            if(arrs[m] <= target) {
                low = m +1;
            } else {
                high = m - 1;
            }
        }
        if(high >= 0 && arrs[high] == target) {
            return high;
        }
        return -1;
    }

    /**
     *3 查找最后一个小于target的元素.也就是说返回小于target的最右边元素下标。
     *
     * @param arrs
     * @param target
     * @return
     */
    public static int findLastSmaller(int[] arrs, int target) {
        int low = 0;
        int high = arrs.length - 1;
        int m = 0;

        while(low <= high) {
            m = low + (high - low) / 2;
            //条件就是题目中的小于target
            if(arrs[m] < target) {
                low = m +1;
            } else {
                high = m - 1;
            }
        }
        //返回最右边
        return high;
    }

    /**
     * 4 查找第一个等于或者大于target的元素
     *
     * @param arrs
     * @param target
     * @return
     */
    public static int findFirstEqualLarger(int[] arrs, int target) {
        int low = 0;
        int high = arrs.length - 1;
        int m = 0;

        while(low <= high) {
            m = low + (high - low) / 2;
            //条件就是题目中的等于或者大于target
            if(arrs[m] >= target) {
                high = m - 1;
            } else {
                low = m +1;
            }
        }
        //返回最左边
        return low;
    }


    private static String solution1(String line) {
        // 在此处理单行数据
        String strs[] = line.split(" ");
        String numStr[] = strs[0].split(",");
        int targer = Integer.parseInt(strs[1]);

        int nums[] = new int[numStr.length];


        for(int i = 0; i < numStr.length; i++){
            nums[i] = Integer.valueOf(numStr[i]);
        }

        int left =0,right = nums.length - 1,mid;
        while(left <= right){

            mid = (left + right) / 2;

            if(nums[mid] == targer){
                return String.valueOf(mid);
            }else if(nums[mid] > targer ){
                if(targer >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] < targer){
               if(targer <= nums[right] ){
                   left = mid + 1;
               }else{
                   right = mid - 1;
               }
            }
        }
        // 返回处理后的结果
        return "-1";
    }

    public static int search(int[] nums, int targer) {

        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == targer) {
                return mid;
            } else if( nums[mid] > targer){
                if(nums[mid] > nums[left] && targer < nums[left]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else {
                if(nums[mid] > nums[left] && targer > nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

//            if(nums[mid] > nums[left]){
//                if(nums[left] <= targer && targer < nums[mid]){
//                    right = mid - 1;
//                }else{
//                    left = mid + 1;
//                }
//            }else{
//                if(nums[right] >= targer && nums[mid] < targer){
//
//                }
//            }
        }
        return -1;
    }


    public static double  findMedianSortedArrays(int[] num1, int[] num2) {

        int m = num1.length;
        int n = num2.length;

        if(n < m){
            int temp[] = num1;
            num1 = num2;
            num2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0,iMax = m,halfIndex = (m + n + 1) / 2;


        int i = (iMin + iMax) / 2;
        int j = halfIndex - i;
        while(iMin <= iMax){

            if(i > iMin && num1[i -1] > num2[j]){
                iMax = i - 1;
            }
            else if(i < iMax && num2[j - 1] > num1[i]){
                iMin = i + 1;
            }else{
                int maxLeft;
                if(i == 0){
                    maxLeft = num2[j - 1];
                }else if(j == 0){
                    maxLeft = num1[i - 1];
                }else{
                    maxLeft = Math.max(num1[i - 1],num2[j - 1]);
                }

                if((m + n) % 2 == 1){
                    return maxLeft;
                }

                int minRight;
                if(i == m){
                    minRight = num2[j];
                }else if(j == n){
                    minRight = num1[i];
                }else{
                    minRight = Math.min(num1[i],num2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
            i = (iMin + iMax) / 2;
            j = halfIndex - i;
        }

        return 0.0;
    }
}
