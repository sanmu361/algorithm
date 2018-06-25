package com.sanmu.algorithm.数学;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-20 10:10
 **/
public class Combination {
    public static void main(String[] args) {
        System.out.println(solution("1,2,3 4"));
    }

    private static String solution(String line) {
        // 在此处理单行数据

        String[] ns = line.split(" ");

        String[] nums = ns[0].split(",");
        int[] ints = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ints[i] = Integer.valueOf(nums[i]);
        }

        int result = 0;
        int target = Integer.valueOf(ns[1]);

        for(int i = 0; i < ints.length; i++){
            result += count(ints,target - ints[i]);
        }

        // 返回处理后的结果
        return String.valueOf(result);
    }

    private static int count(int[] nums,int target){
        int result = 0;
        if(target == 0){
            return 1;
        }else if(target < 0){
            return 0;
        }else{
            for(int i = 0; i < nums.length; i++){
                result += count(nums,target - nums[i]);
            }
        }
        return result;
    }
}
