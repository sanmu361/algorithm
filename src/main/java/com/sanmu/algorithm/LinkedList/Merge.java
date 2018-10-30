package com.sanmu.algorithm.LinkedList;

import java.util.ArrayList;
import java.util.List;

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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                result = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                result = new ListNode(l1.val);
                l1 = l1.next;
            }
        }
        ListNode temp = result;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null ){
            if(temp != null){
                temp.next = l1;
            }else{
                temp = l1;
            }
        }
        if(l2 != null){
            if(temp != null){
                temp.next = l2;
            }else{
                temp = l2;
            }
        }
        return result;

    }

    public static ListNode mergeKLists(ListNode[] lists) {


        ListNode result = new ListNode(0);
        ListNode temp = result;


        while(lists.length > 0 ){
            ListNode nowNode = null;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null){
                    nowNode = lists[i];
                    lists[i] = nowNode.next;
                    break;
                }
            }
            if(nowNode == null){
                break;
            }
            int nowIndex = 0;
            for(int i = nowIndex; i < lists.length; i ++){
                if(lists[i] != null){
                    if(nowNode.val > lists[i].val){
                        lists[nowIndex] = nowNode;
                        nowNode = lists[i];
                        nowIndex = i;
                        lists[i] = nowNode.next;
                    }
                }

            }
            temp.next = nowNode;
            lists[nowIndex] = nowNode.next;
            temp = temp.next;

        }

        result = result.next;
        return result;

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            ListNode temp2 = temp.next;
            if(temp2 != null){
                int tempInt = temp.val;
                temp.val = temp2.val;
                temp2.val = tempInt;
            }else{
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> temp = new ArrayList<ListNode>();
        ListNode tempNode = head;
        for(int i = 0; i < k && tempNode != null ; i++){
            temp.add(tempNode);
            tempNode = tempNode.next;
        }
        while(temp.size() == k){
            int i = 0,j = k-1;
            while(i < j){
                int tempInt = temp.get(i).val;
                temp.get(i).val = temp.get(j).val;
                temp.get(j).val = tempInt;
                i++;
                j--;
            }
            temp.clear();
            for( i = 0; i < k && tempNode != null ; i++){
                temp.add(tempNode);
                tempNode = tempNode.next;
            }

        }

        return head;

    }

    public static int removeDuplicates(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }

        int flag = nums[0];
        result = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != flag){
                result++;
                flag = nums[i];
            }
        }

        return result;

    }

    public static void main(String[] args) {
//        ListNode listNode =  new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        listNode.next = listNode2;
//        listNode1.next = listNode3;
//        listNode2.next = listNode4;
//        listNode3.next = listNode5;

//        ListNode[] temp = new ListNode[]{listNode};

        int[] a = new int[]{1,1,2};
        removeDuplicates(a);
    }
}
