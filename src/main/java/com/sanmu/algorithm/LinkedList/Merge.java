package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-17 15:41
 **/
public class Merge extends AbstractLinkedList {
    @Override
    protected void doSomeThing(Node list) {

    }

    public void marge(Node head1,Node head2){
        Node head = null;
        Node temp = head;
        Integer lastValue = null;

        if(head1 == null && head2 != null){
          head = head2;

        }else if(head1 != null && head2 == null){
           head = head1;

        }else if( head1 != null && head2 != null ){
            while(head1 != null && head2 != null){
               Node node = null;
                if(head1.getValue() < head2.getValue()){
                    node = head1;
                    head1 = head1.getNext();
                }else if(head1.getValue() > head2.getValue()){
                    node = head2;
                    head2 = head2.getNext();
                }else{
                    node = head1;
                    head1 = head1.getNext();
                    head2 = head2.getNext();
                }

               if(head == null){
                    head = node;
                    temp = head;
               }else{
                   temp.setNext(node);
                   temp = temp.getNext();
               }
            }

            while(head1 != null){
                if(lastValue != null && lastValue != head1.getValue()){
                    Node node = new Node(head1.getValue(),null);
                    temp.setNext(node);
                    temp = temp.getNext();
                }else if(lastValue == null){
                    lastValue = head1.getValue();
                    Node node = new Node(head1.getValue(),null);
                    temp.setNext(node);
                    temp = temp.getNext();
                }
                head1 = head1.getNext();
            }

            while(head2 != null){
                if(lastValue != null && lastValue != head2.getValue()){
                    Node node = new Node(head2.getValue(),null);
                    temp.setNext(node);
                    temp = temp.getNext();
                }else if(lastValue == null){
                    lastValue = head2.getValue();
                    Node node = new Node(head2.getValue(),null);
                    temp.setNext(node);
                    temp = temp.getNext();
                }
                head2 = head2.getNext();
            }

        }

        head = head.getNext();
        ergodic(head);
    }
}
