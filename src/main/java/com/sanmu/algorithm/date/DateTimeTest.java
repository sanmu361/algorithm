package com.sanmu.algorithm.date;

import org.joda.time.DateTime;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-10-26 9:59
 **/
public class DateTimeTest {

    public static void main(String[] args) {
        DateTime time = new DateTime();

        System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));

        time.plusDays(1);

        System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));

        time = time.plusDays(1);

        System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));

    }
}
