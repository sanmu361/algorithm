package com.sanmu.algorithm.LinkedList;

import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 15:20
 **/
public class LastNodeK extends AbstractLinkedList {

    @Override
    protected void doSomeThing(Node list) {
        if(list == null){
            return ;
        }
        Node first = list;
        Node second = list;
        Random random = new Random();

        int k =  random.nextInt(100);

        for(int i = 0; i < k - 1; i++){
            second = second.getNext();
            if(second == null){
                System.out.println("倒数超长！！！");
                return;
            }
        }

        while(second != null){
            second = second.getNext();
            first = first.getNext();
        }
        System.out.println("倒数第" + k + "个节点是:" + first.getValue());
    }

    public static void main(String[] args) {
        LastNodeK lastNodeK = new LastNodeK();
        lastNodeK.TestTheOpreater();
    }
}
