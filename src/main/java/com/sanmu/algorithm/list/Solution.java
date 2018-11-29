package com.sanmu.algorithm.list;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-21 10:33
 **/
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;


        ListNode result = rotateRight(l1,4);

        System.out.println(result);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        int n = 1;

        ListNode cur = head;
        while(cur.next != null){
            n++;
            cur = cur.next;
        }


        cur.next = head;

        System.out.println(4 % 3);

        int m = Math.abs(n - k % n);

        for(int i = 0; i < m; i++){
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;


    }

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

}
