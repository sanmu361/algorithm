package com.sanmu.algorithm.string;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-05 17:55
 **/
public class Swap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "aa";
        String b = "bbbbbbbbbbb";
        swap(a,b);

        System.out.println("a值：" + a + " length:" + a.length());
        System.out.println("b值：" + b + " length:" + b.length());
    }

    public static void swap(String a, String b) throws NoSuchFieldException, IllegalAccessException {
        Field field = String.class.getDeclaredField("value");

        field.setAccessible(true);

        Object aValue = field.get(a);
        Object bValue = field.get(b);
        field.set(a,bValue);
        field.set(b,aValue);
    }
}
