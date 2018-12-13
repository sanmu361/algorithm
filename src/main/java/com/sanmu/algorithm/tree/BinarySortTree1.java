package com.sanmu.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-04 19:45
 **/
public class BinarySortTree1 {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int value){
        if(this.root == null){
            this.root = new Node(value);
            return;
        }
        Node currentNode = this.root;
        Node parentNode = this.root;

        boolean isLeft = true;
        while(currentNode != null){
            parentNode = currentNode;
            if(value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
                isLeft = true;
            }else if(value > currentNode.getValue()){
                currentNode = currentNode.getRight();
                isLeft = false;
            }else{
                return;
            }
        }

        Node newNode = new Node(value);
        if(isLeft){
            parentNode.setLeft(newNode);
        }else {
            parentNode.setRight(newNode);
        }
    }

    public boolean delete(int value){
        Node currentNode = this.root;
        Node parentNode = this.root;

        boolean isLeft = true;

        while(currentNode != null && currentNode.getValue() != value){
            parentNode = currentNode;
            if(value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
                isLeft = true;
            }else{
                currentNode = currentNode.getRight();
                isLeft = false;
            }

            if(currentNode == null){
                return false;
            }

            if(currentNode.getLeft() == null && currentNode.getRight() == null){
                if(currentNode == this.root){
                    this.root = null;
                }else if(isLeft){
                    parentNode.setLeft(null);
                }else{
                    parentNode.setRight(null);
                }
            }else if(currentNode.getLeft() != null && currentNode.getRight() == null){
                if(currentNode == this.root){
                    this.root = currentNode.getLeft();
                }else if(isLeft){
                    parentNode.setLeft(currentNode.getLeft());
                }else{
                    parentNode.setRight(currentNode.getLeft());
                }
            }else if(currentNode.getLeft() == null && currentNode.getRight() != null){
                if(currentNode == this.root){
                    this.root = currentNode.getRight();
                }else if(isLeft){
                    parentNode.setLeft(currentNode.getRight());
                }else{
                    parentNode.setRight(currentNode.getRight());
                }
            }else{
                Node directPostNode = this.getDirectPostNode(currentNode);
                currentNode.setValue(directPostNode.getValue());
            }
        }
        return true;
    }

    public Node getDirectPostNode(Node delNode){
        Node parentNode = delNode;
        Node directPostNode = delNode;
        Node currentNode = delNode.getRight();
        while(currentNode != null){
            parentNode = directPostNode;
            directPostNode = currentNode;
            currentNode = currentNode.getLeft();
        }

        if(directPostNode != delNode.getRight()){
            parentNode.setLeft(directPostNode.getRight());
            directPostNode.setRight(null);
        }
        return directPostNode;
    }

    public Node find(int value){
        if(this.root == null){
            return null;
        }

        Node parentNode = this.root;
        Node currentNode = this.root;

        while (currentNode != null){
            parentNode = currentNode;
            if(value > currentNode.getValue()){
                currentNode = currentNode.getRight();
            }else if(value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
            }else{
                return currentNode;
            }
        }
        return null;
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.println(root.getValue());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void midOrder(Node root){
        if(root != null){
            midOrder(root.getLeft());
            System.out.println(root.getValue());
            midOrder(root.getRight());
        }
    }

    public void postOrder(Node root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getValue());
        }
    }

    public void BFS(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.getLeft() != null){
                queue.offer(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.offer(temp.getRight());
            }
            System.out.println(temp.getValue());
        }
    }



    public static void main(String[] args) {
        BinarySortTree1 tree1 = new BinarySortTree1();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            tree1.insert(random.nextInt(100));
        }

        tree1.BFS(tree1.getRoot());

        System.out.println(123);
    }

    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
