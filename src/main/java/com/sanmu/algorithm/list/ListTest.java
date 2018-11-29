package com.sanmu.algorithm.list;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-12 9:52
 **/
public class ListTest {

    public static void main(String[] args) {
        ArrayList<Integer> temp1 = Lists.newArrayList(1,6);

        List<Integer> temp2 = (ArrayList<Integer>)temp1.clone();


        temp1.remove(0);

        temp1.add(0,0);

        System.out.println(temp1);
        System.out.println(temp2);
    }
}
