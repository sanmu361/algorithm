package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-14 10:52
 **/
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }
public class Solution {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(-1);
        ListNode a2 = new ListNode(5);
        a1.next = a2;
        ListNode a3 = new ListNode(3);
        a2.next = a3;
        ListNode a4 = new ListNode(4);
        a3.next = a4;
        ListNode a5 = new ListNode(0);
        a4.next = a5;

        ListNode result = sortList(a1);

        System.out.println(1);
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode preCur = head;


        while(cur !=null){
            ListNode preTemp = null;
            ListNode temp = head;

            ListNode curTemp = cur.next;
            while(temp != cur && temp.val < cur.val){
                preTemp = temp;
                temp = temp.next;
            }

            if(temp != cur){
                if(preTemp == null){
                    head = cur;
                    cur.next = temp;
                }else{
                    preTemp.next = cur;
                    cur.next = temp;
                }
                preCur.next = curTemp;
            }else{
                preCur = cur;
            }
            cur = curTemp;
        }

        return head;
    }

    public static ListNode sortList(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return mergeSort(head,count);
    }

    public static ListNode mergeSort(ListNode head,int n){
        if(head == null || n == 0){
            return null;
        }

        if(n == 1){
            return head;
        }

        int count = n / 2;
        int num = 0;
        ListNode preTemp = null;
        ListNode temp = head;
        while(num < count){
            num++;
            preTemp = temp;
            temp = temp.next;
        }
        if(preTemp == null){
            return head;
        }
        preTemp.next = null;

        ListNode m1 = mergeSort(head,count);
        ListNode m2 = mergeSort(temp,n - count);
        ListNode result = null;
        ListNode rTemp = null;

        while(m1 != null && m2 != null){
            ListNode t = null;
            if(m1.val < m2.val){
                t = new ListNode(m1.val);
                m1 = m1.next;
            }else{
                t = new ListNode(m2.val);
                m2 = m2.next;
            }

            if(result == null){
                result = t;
                rTemp = t;
            }else{
                rTemp.next = t;
                rTemp = rTemp.next;
            }
        }

        if(m1 != null){
            rTemp.next = m1;
        }

        if(m2 != null){
            rTemp.next = m2;
        }
        return result;
    }
}
