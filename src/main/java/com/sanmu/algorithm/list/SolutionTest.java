package com.sanmu.algorithm.list;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-10 13:27
 **/
public class SolutionTest {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode curNode = null;
        for(int i = 1; i < 6; i++){
            if(head == null){
                head = new ListNode(i);
                curNode = head;
            }else{
                curNode.next = new ListNode(i);
                curNode = curNode.next;
            }
        }
        System.out.println(reverseBetween1(head,2,4));

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode curNode = tempHead;
        ListNode newNode = tempHead;
        ListNode CurParentNode = null;
        int i = 1;
        while(i < m){
            i++;
            curNode = curNode.next;
        }


        ListNode pNode = curNode;
        ListNode fNode = curNode.next;
        ListNode lastNode = null;
        curNode = curNode.next;

        while(i <= n){
            ListNode temp = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = temp;
            i++;
        }

        pNode.next = lastNode;
        fNode.next = curNode;

        return null;
    }

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode curNode = nHead;

        int i = 1;
        while(i < m){
            curNode = curNode.next;
        }

        ListNode pre = curNode;
        ListNode first = curNode.next;
        ListNode last = null;
        curNode = curNode.next;

        while(i <= n){
            ListNode temp = curNode.next;
            curNode.next = last;
            last = curNode;
            curNode = temp;
            i++;
        }
        first.next = curNode;
        pre.next = last;
        return nHead.next;
    }

    public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }


  }

}
