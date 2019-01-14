package com.sanmu.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-08 10:27
 **/
  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class Solution3 {

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);

        r1.next= r2;
        r2.next = r3;

        r1.random = r3;
        r2.random = r1;
        r3.random = r2;

        RandomListNode node = copyRandomList(r1);

        System.out.println(node);
    }

    public static RandomListNode copyRandomList(RandomListNode head) {

        if(head == null){
            return null;
        }

        RandomListNode temp = head;

        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();

        while(temp!= null){
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            node.random = temp.random;
            map.put(temp,node);
            temp = temp.next;
        }


        RandomListNode newH = map.get(head);

        RandomListNode tempN = newH;

        while(tempN != null){
            tempN.next = map.get(tempN.next);
            tempN.random = map.get(tempN.random);
            tempN = tempN.next;
        }

        return newH;

    }
}
