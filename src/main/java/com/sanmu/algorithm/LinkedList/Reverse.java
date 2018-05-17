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

        Node newList = null;
        Node head = list;
        Node next = null;

        while(head != null){
            next = head.getNext();
            head.setNext(newList);
            newList = head;
            head = next;
        }
    }
}
