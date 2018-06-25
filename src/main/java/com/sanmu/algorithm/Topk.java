package com.sanmu.algorithm;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-20 20:25
 **/
public class Topk {
    public static void main(String[] args) {
        System.out.println(solution("1,2,2,3,3 3"));
    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(" ");
        String[] nums = strs[0].split(",");

        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+ 1);
            }
        }

        List<Map.Entry<String,Integer>> list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int k = Integer.valueOf(strs[1]);


        TreeMap<String,Integer> map1 = new TreeMap<>();

        for(int i = 0; i < k; i++){
            map1.put(list.get(i).getKey(),list.get(i).getValue());
        }
        List<Map.Entry<String,Integer>> list1 = new LinkedList(map1.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        StringBuilder stringBuilder = new StringBuilder(list1.get(0).getKey());

        for(int i = 1; i < k; i++){
            stringBuilder.append(",").append(list1.get(i).getKey());
        }


        // 返回处理后的结果
        return stringBuilder.toString();
    }
}
