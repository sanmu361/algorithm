package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 15:08
 **/
public class Count extends AbstractLinkedList{

    @Override
    protected void doSomeThing(Node list) {
        int count = 0;
        while(list != null){
         count++;
         list = list.getNext();
        }
        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
        Count count = new Count();
        count.TestTheOpreater();
    }


}
