package com.sanmu.algorithm.dp;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-14 15:17
 **/
public class MaxsubArray {

    public static void main(String[] args) {
        int a[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        int sum=nums[0];
        int n=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(n>0){
                n+=nums[i];
            }
            else{
                n=nums[i];
            }
            if(sum<n){
                sum=n;
            }
        }
        return sum;
    }
}
