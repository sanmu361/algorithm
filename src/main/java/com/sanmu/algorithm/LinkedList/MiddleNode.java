package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 15:33
 **/
public class MiddleNode extends AbstractLinkedList{
    @Override
    protected void doSomeThing(Node list) {
        Node first = list;
        Node second = list;

        while(first != null && second != null && second.getNext() != null){
            first = first.getNext();
            second = second.getNext().getNext();
        }
        if(first != null){
            System.out.println("中间值：" + first.getValue() + "/n下一个：" + first.getNext().getValue());
        }
    }

    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();
        middleNode.TestTheOpreater();
    }
}
