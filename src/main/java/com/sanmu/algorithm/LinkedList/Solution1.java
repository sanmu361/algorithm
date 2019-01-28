package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-23 10:41
 **/
public class Solution1 {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};

        rotate(nums,3);

        int m = Integer.MIN_VALUE;


//        System.out.println(Integer.)
        System.out.println(nums);


    }

    public static void rotate(int[] nums, int k) {
        if(nums == null || k == 0){
            return;
        }

        int[] temp = new int[nums.length];

        int yu = k % nums.length;

        if(yu == 0){
            return;
        }

        for(int i = yu - 1,j = 0; nums.length - 1 - i <= nums.length - 1; i--,j++){
            temp[j] = nums[nums.length - 1 - i];
        }

        for(int i = 0,j = yu; i <= nums.length - 1 - yu; i++,j++){
            temp[j] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }

    }

}
