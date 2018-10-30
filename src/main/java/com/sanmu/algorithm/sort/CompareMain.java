package com.sanmu.algorithm.sort;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-09-18 17:31
 **/
public class CompareMain {

    public static void main(String[] args) {
        List<Integer> a = Lists.newArrayList();

        for(int i = 0; i < 10; i++){
            a.add(i);
        }

        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(a.get(a.size() - 1));
    }
}
