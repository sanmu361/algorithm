package com.sanmu.algorithm.LinkedList;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 14:35
 **/
public abstract class AbstactLinkedList {

    protected abstract void doSomeThing(Node list);

    protected abstract void ergodic(Node list);

    protected abstract Node create();


    public void TestTheOpreater(){
        Node list = create();
        ergodic(list);
        doSomeThing(list);
        ergodic(list);
    }

    protected class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

}
