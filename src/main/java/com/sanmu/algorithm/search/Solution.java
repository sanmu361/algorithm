package com.sanmu.algorithm.search;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-08 11:42
 **/
public class Solution {

    public static void main(String[] args) {
        int a[] = {2,1};
        System.out.println(firstMissingPositive(a));
    }
    public static int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]){
                int index = nums[i];
                nums[i] = nums[index - 1];
                nums[index - 1] = index;
            }
        }
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}