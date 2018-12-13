package com.sanmu.algorithm.greedy;

import java.util.ArrayList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-24 14:52
 **/
public class RemoveK {

    public static void main(String[] args) {
        System.out.println(solution1("1234567890,8"));
    }

    private static String solution(String line){
        String[] nums = line.split(",");

        StringBuilder builder = new StringBuilder(nums[0]);
        int k = Integer.parseInt(nums[1]);

        int i = 0,j = 0;
        builder.append(0);

        while(j < k){
            for(i = 0; i < builder.length() - 1; i++){
                if(builder.charAt(i) > builder.charAt(i + 1) ){
                    builder = builder.replace(i ,i+ 1,"");
                    j++;
                    break;
                }
            }
        }

        builder.replace(builder.length() - 1,builder.length(),"");



        while(builder.charAt(0) == '0' && builder.length() != 1){
            builder.replace(0,1,"");
        }

        return builder.toString();
    }

    private static String solution1(String line){
        String[] nums = line.split(",");

        StringBuilder builder  = new StringBuilder(nums[0]);
        int sum = 0;
        int k = builder.length() - Integer.parseInt(nums[1]);

        int i = 0,j = 0;
        while(j < k){
            int minIndex = i;
            for(; i < builder.length(); i++){
                if(builder.charAt(i) < builder.charAt(minIndex) ){
                    minIndex = i;
                }
            }
            i = (minIndex + 1) % nums[0].length();
            j++;

            sum = sum * 10 + builder.charAt(minIndex) - '0';
        }
        return String.valueOf(sum);
    }

    private static String solution3(String line) {
        // 在此处理单行数据
        long oldValue = Long.parseLong(line.split(",")[0]);
        int k = Integer.parseInt(line.split(",")[1]);
        ArrayList<Long> arrayList = new ArrayList<Long>();
        while (oldValue != 0) {
            arrayList.add(oldValue % 10);
            oldValue = oldValue / 10;
        }

        int startIndex = arrayList.size() - 1;
        long sum = 0;
        int lastLength = arrayList.size() - k;
        while (lastLength > 0) {
            int minIndex = startIndex;
            for (int i = startIndex; i >= lastLength - 1; i--) {
                if (arrayList.get(i) < arrayList.get(minIndex)) {
                    minIndex = i;
                }
            }
            startIndex = minIndex - 1;
            lastLength--;
            sum = sum * 10 + arrayList.get(minIndex);
        }

        // 返回处理后的结果
        return String.valueOf(sum);
    }
}
