package com.sanmu.algorithm.search;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-21 10:09
 **/
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(solution1("3,4,5,6,7,0,1,2 2"));
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
                if(targer >= nums[left] || nums[mid] < nums[right]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] < targer){
               if(targer <= nums[right] || nums[mid] > nums[left] ){
                   left = mid + 1;
               }else{
                   right = mid - 1;
               }
            }
        }
        // 返回处理后的结果
        return "-1";
    }
}
