package com.sanmu.algorithm.matrix;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-16 11:18
 **/
public class Solution {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if(intervals == null || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }

        int start = search(intervals,newInterval.start,true);
        int end = search(intervals,newInterval.end,false);


        if(start <= end){

            newInterval.start = Math.min(newInterval.start,intervals.get(start).start);

            if(end == intervals.size()){
                newInterval.end = Math.max(newInterval.end,intervals.get(intervals.size() - 1).end);
            }else{
                newInterval.end = Math.max(newInterval.end,intervals.get(end).end);
            }

            for(int i = 0; start + i <= end; i++){
                intervals.remove(start);
            }
            intervals.add(start,newInterval);

        }else{
            intervals.add(start,newInterval);
        }
        StringBuilder S = new StringBuilder();



        return intervals;
    }

    public static void main(String[] args) {
        Interval interval = new Interval(1,2);
        Interval interval1 = new Interval(3,5);
        Interval interval2 = new Interval(6,7);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(12,16);

        List<Interval> list = Lists.newArrayList(interval,interval1,interval2,interval3,interval4);

        insert(list,new Interval(20,20));


    }

    public static int search(List<Interval> intervals, int target,boolean flag){
        int l = 0;
        int r = intervals.size() - 1;
        int m = 0;

        while(l <= r){
            m = (l + r) / 2;

            if(intervals.get(m).start > target){
                r = m - 1;
            }else if(intervals.get(m).end < target){
                l = m + 1;
            }else{
                return m;
            }
        }
        if(flag){
            return l;
        }else{
            return r;
        }
    }

    static class Interval {

     int start;
      int end;
      Interval() { start = 0; end = 0; }
      public Interval(int s, int e) { start = s; end = e; }
  }
}
