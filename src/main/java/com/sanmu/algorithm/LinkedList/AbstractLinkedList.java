package com.sanmu.algorithm.LinkedList;

import java.util.List;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 14:42
 **/
public abstract class AbstractLinkedList extends AbstactLinkedList {

    protected Node create(){
        Random random = new Random();
        Node head = new Node(random.nextInt(100),null);
        Node temp = head;

        int length = random.nextInt(100);

        for(int i = 0; i < length; i++){
         Node node = new Node(random.nextInt(100),null);
         temp.setNext(node);
         temp = temp.getNext();
        }

        return head;
    }

    protected void ergodic(Node list) {
        System.out.println("遍历");
        while(list != null){
            System.out.println(list.getValue());
            list = list.getNext();
        }
        System.out.println();
    }
}
