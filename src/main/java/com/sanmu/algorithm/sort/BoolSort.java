package com.sanmu.algorithm.sort;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-23 16:41
 **/
public class BoolSort {
    public static void main(String[] args) {
        System.out.println(solution2("2,3,1"));
    }

    private static String solution(String line){
        String[] numStr = line.split(",");
        int[] nums = new int[numStr.length];

        for(int i = 0; i < numStr.length; i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length ; j++){
                if(nums[i] > nums[j]){
                    count += j - i;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return String.valueOf(count);
    }

    private static String solution1(String line){
        String[] numStr = line.split(",");
        int[] nums = new int[numStr.length];

        for(int i = 0; i < numStr.length; i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int count = 0;
        for(int i=1;i<nums.length;i++){
            //从1开始表示：假设A[0] 已经放好位置了,后面的数字就是插入到它左边还是右边的问题。

            if(nums[i] < nums[i-1]){ //发现A[i]比前面的有序数组的最后一个数小了

                int tmp = nums[i];//缓存下A[i]
                int j;
                for(j=i-1; j>=0 && nums[j] > tmp; j--){ //从后往前逐个排查哪个位置刚好适合A[i],最后一次j--可能会为负值，这是为了配合后面A[j+1]
                    nums[j+1] = nums[j];
                }
                nums[j+1] = tmp;
            }

        }

        return String.valueOf(count);
    }

    private static String solution2(String line){
        String[] numStr = line.split(",");
        int[] nums = new int[numStr.length];

        for(int i = 0; i < numStr.length; i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int count = 0;

        for(int i = 0 ; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    count++;
                }
            }

        }

        return String.valueOf(count);

    }
}
