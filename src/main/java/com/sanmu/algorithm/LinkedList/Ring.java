package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-23 18:01
 **/
public class Ring extends AbstractLinkedList{

    public static void main(String[] args) {

    }

    @Override
    protected void doSomeThing(Node list) {

    }

    public void judgeRing(Node list){
        Node fast = list;
        Node slow = list;

        if(list == null){
            return ;
        }

        while(true){
            if(slow.getNext() != null && fast.getNext() != null && fast.getNext().getNext() != null){
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }else{
                return;
            }

            if(fast == slow){
                System.out.println(fast);
            }
        }
    }

    public int ringLength(Node list,Node ringMeetNode){
        Node fast = list;
        Node slow = ringMeetNode;

        int length = 0;
        while(true){
            fast = fast.getNext();
            slow = slow.getNext();
            length++;
            if(fast == slow){
                break;
            }
        }
        return length;
    }


}
