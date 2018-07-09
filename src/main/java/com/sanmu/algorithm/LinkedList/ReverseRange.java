package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-06 11:35
 **/
public class ReverseRange {

    public static void main(String[] args) {
        List head = create();
        reverse(head,3,6);
        System.out.println(head);
    }

    private static List create(){
        List head = new List(11);
        for(int i= 10; i >= 1 ;i--){
            List temp = new List(i);
            temp.setNext(head);
            head = temp;
        }

        return head;
    }

    private static void reverse(List head,int n,int m){
        int i = 0;

        List cur =head;
        for(; i < n - 1; i++){
            head =cur;
            cur = cur.getNext();
        }

        List pre = cur;
        List next = null;

        for(; i < m; i++){
            next = cur.getNext();
            cur.setNext(head.getNext());
            head.setNext(cur);
            pre.setNext(next);
            cur = next;
        }

    }

    private static void reverse(List head){
        List cur = head;
        List next = null;
        List pre = null;

        while(cur != null){
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        head = pre;
    }

    private static class List{
        int value;
        List next;

        public List(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public List getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(List next) {
            this.next = next;
        }
    }
}
