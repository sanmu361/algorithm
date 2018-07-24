package com.sanmu.algorithm.LinkedList;

import org.w3c.dom.NodeList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-23 18:02
 **/
public class CrossPoint extends AbstractLinkedList {
    @Override
    protected void doSomeThing(Node list) {

    }


    public void doSomeThing(Node list1 ,Node list2){
        int length1 = 0,length2 = 0;
        Node temp = list1;
        while(temp != null){
            length1++;
            temp = temp.getNext();
        }
        temp = list2;
        while(temp != null){
            length2++;
            temp = temp.getNext();
        }

        if(length1 > length2){
            for(int i = 0; i < length1 - length2; i++){
                list1 = list1.getNext();
            }
        }else{
            for(int i = 0; i < length2 - length1; i++){
                list2 = list2.getNext();
            }
        }

        while(list1 != null){
            if(list1 == list2){
                System.out.println(list1.getValue());
                break;
            }
            list1 = list1.getNext();
            list2 = list2.getNext();
        }
    }
}
