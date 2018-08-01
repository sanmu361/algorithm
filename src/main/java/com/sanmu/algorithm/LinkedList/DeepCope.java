package com.sanmu.algorithm.LinkedList;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-25 12:02
 **/
public class DeepCope extends AbstractLinkedList{

    @Override
    protected void doSomeThing(Node list) {

    }

    public void copy(RandomNode deep){
        Map<RandomNode,RandomNode>  map = Maps.newHashMap();
        RandomNode head = deep;

        while(deep.getNext() != null){
            RandomNode temp = new RandomNode(deep.getValue(),deep.getNext());
            map.put(deep,temp);
        }

        for(RandomNode key : map.keySet()){
            RandomNode value = map.get(key);

            RandomNode temp = map.get(value.getNext());
            RandomNode randomTemp = map.get(value.getRandom());
            value.setRandom(randomTemp);
            value.setNext(temp);
        }

        System.out.println(map.get(head));


    }


    class RandomNode extends Node {
        public RandomNode(int value, Node next) {
            super(value, next);
        }

        private Node random;

        public void setRandom(Node random) {
            this.random = random;
        }

        public Node getRandom() {
            return random;
        }

    }
}
