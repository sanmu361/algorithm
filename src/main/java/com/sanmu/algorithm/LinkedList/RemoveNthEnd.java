package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-10-29 10:25
 **/
public class RemoveNthEnd {

    public static void main(String[] args) {
        ListNode listNode =  new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        removeNthFromEnd(listNode,2);
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        for(int i = 0; i < n - 1; i++){
            second = second.next;
            if(second == null){
                return null;
            }
        }
        ListNode temp = first;
        while(second.next != null){
            temp = first;
            second = second.next;
            first = first.next;
        }
        if(first.equals(temp)){
            head = temp.next;
        }else{
            temp.next = first.next;
        }

        return head;
    }
}

 class ListNode {
    int val;
     ListNode next;
      ListNode(int x) { val = x; }
}
