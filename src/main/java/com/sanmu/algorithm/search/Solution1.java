package com.sanmu.algorithm.search;

import java.util.Arrays;
import java.util.Collections;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-29 10:06
 **/
public class Solution1 {
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int l1 =0,r1= matrix.length - 1;
        int mid = -1;

        while(l1 <= r1){
            mid = (l1 + r1) / 2;
            if(matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] > target){
                break;
            }else if(matrix[mid][0] > target){
                r1 = mid - 1;
            }else if(matrix[mid][matrix[mid].length - 1] < target ){
                l1 = mid + 1;
            }else if(matrix[mid][0] == target || matrix[mid][matrix[mid].length - 1] == target){
                return true;
            }
        }


        if(r1 < l1 || mid < 0){
            return false;
        }else{
            int l2 = 0,r2 = matrix[mid].length - 1;
            while(l2 <= r2){
                int mid1 = (l2 + r2) / 2;
                if(matrix[mid][mid1] > target){
                    r2 = mid1 - 1;
                }else if(matrix[mid][mid1] < target){
                    l2 = mid1 + 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        searchMatrix(a,11);
        int[] b = new int[]{1};
        System.out.println(findMin(b));
    }

    public static int findMin(int[] nums) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                if(nums[mid] < nums[nums.length - 1]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
               if(mid == 0){
                   return Math.min(nums[mid],nums[mid + 1]);
               }
               if(mid == nums.length - 1){
                   return Math.min(nums[mid],nums[mid - 1]);
               }

               if(nums[mid] > nums[mid + 1]){
                   return nums[mid + 1];
               }else{
                   return nums[mid];
               }
            }
        }

        return nums[0];
    }

}
