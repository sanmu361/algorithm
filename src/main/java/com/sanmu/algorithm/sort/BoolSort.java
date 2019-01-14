package com.sanmu.algorithm.sort;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-23 16:41
 **/
public class BoolSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        quickSort(nums,0,nums.length - 1);
        System.out.println(nums);
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


    public static void boolSort(int nums[]){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void insertSort(int nums[]){

        for(int i = 1; i < nums.length ; i++){
            int temp = nums[i];
            int j = i - 1;
            for(; j >= 0 && nums[j] > temp; j--){
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    public static void insertSort1(int nums[]){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];

            int j = i - 1;

            for(; j >= 0 && nums[j] < temp; j--){
                nums[j + 1] = nums[j];
            }

            nums[j + 1] = temp;
        }
    }

    public static void selectSort(int nums[]){
        for(int i = 0; i < nums.length - 1; i++){
            int max = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[max] < nums[j]){
                    max = j;
                }
            }
            if(max != i){
                int temp = nums[max];
                nums[max] = nums[i];
                nums[i] = temp;
            }

        }
    }

    public static void shellSort(int data[]){
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
    }

    public static void mergeSort(int nums[],int left,int right){
        if(left == right){
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(nums,left,middle);
        mergeSort(nums,middle + 1,right);

        mergeArr(nums,left,middle,right);
    }

    public static void mergeArr(int nums[],int left, int middle,int right){
        int tem[] = new int[right - left + 1];

        int i = left ,j = middle + 1,k =0;

        while(i <= middle && j <= right){
            tem[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        while(i <= middle) {
            tem[k++] = nums[i++];
        }
        while(j <= right) {
            tem[k++] = nums[j++];
        }

        int index = 0;
        while(left <= right) {
            nums[left++] = tem[index++];
        }
    }


    public static void quickSort(int nums[],int low,int high){
        int start = low;
        int end = high;
        int key = nums[low];

        while(end > start){
            while(end > start && nums[end] >= key){
                end--;
            }

            if(nums[end] <= key){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }

            while(end > start && nums[start] <= key){
                start++;
            }

            if(nums[start] >= key){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

        if(start > low) {
            quickSort(nums,low,start - 1);
        }
        if(end < high){
            quickSort(nums,end + 1,high);
        }
    }
}
