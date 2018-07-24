package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 16:15
 **/
public class Reverse extends AbstractLinkedList {
    @Override
    protected void doSomeThing(Node list) {

        Node now = list;
        Node pre = null;
        Node next = null;

        while(now != null){
            next = now.getNext();
            now.setNext(pre);
            pre = now;
            now = next;
        }
    }
}
