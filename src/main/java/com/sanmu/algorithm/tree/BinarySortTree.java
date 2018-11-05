package com.sanmu.algorithm.tree;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-05 12:02
 **/
public class BinarySortTree extends AbstractBinaryTree {

    private Node root;

    public BinarySortTree(Node root) {
        this.root = root;
    }

    @Override
    public Node find(int value) {
        if(root == null){
            return null;
        }

        Node currentNode = this.root;
        while(currentNode != null){
            if(value < currentNode.getValue()){
                currentNode = currentNode.getLeftChild();
            }else if(value > currentNode.getValue()){
                currentNode = currentNode.getRightChild();
            }else{
                return currentNode;
            }
        }

        return null;
    }

    @Override
    public boolean update(int value) {
        Node node = find(value);
        if(null != null){
            node.setValue(value);
        }else{
            return false;
        }

        return true;
    }

    @Override
    public void insert(int value) {
        if(this.root == null){
            this.root = new Node(value);
            return;
        }

        Node currentNode = this.root;
        Node parentNode = this.root;

        boolean isLeftChild = true;

        while(currentNode != null){
            parentNode = currentNode;
            if(value < currentNode.getValue()){
                currentNode = currentNode.getLeftChild();
                isLeftChild = true;
            }else if(value > currentNode.getValue()){
                currentNode = currentNode.getRightChild();
                isLeftChild = false;
            }else{
                break;
            }
        }

        if(parentNode != currentNode){
            Node newNode = new Node(value);
            if(isLeftChild){
                parentNode.setLeftChild(newNode);
            }else{
                parentNode.setRightChild(newNode);
            }
        }else{
            parentNode.setValue(value);
        }
    }

    @Override
    public boolean delete(int value) {
        Node curentNode = this.root;
        Node parentNode = this.root;
        boolean isLeftChild = true;
        while(curentNode != null && curentNode.getValue() != value){
            parentNode = curentNode;
            if(value < curentNode.getValue()){
                curentNode = curentNode.getLeftChild();
                isLeftChild = true;
            }else{
                curentNode = curentNode.getRightChild();
                isLeftChild = false;
            }
        }

        if(curentNode == null){
            return false;
        }
        if(curentNode.getLeftChild() == null && curentNode.getRightChild() == null){
            if(curentNode == this.root){
                this.root = null;
            }else if(isLeftChild){
                parentNode.setLeftChild(null);
            }else{
                parentNode.setRightChild(null);
            }
        }else if(curentNode.getRightChild() == null && curentNode.getLeftChild() != null){
            if(curentNode == this.root){
                this.root = curentNode.getLeftChild();
            }else if(isLeftChild){
                parentNode.setLeftChild(curentNode.getLeftChild());
            }else{
                parentNode.setRightChild(curentNode.getLeftChild());
            }
        }else if(curentNode.getRightChild() != null && curentNode.getLeftChild() != null){
            if(curentNode == this.root){
                this.root = curentNode.getRightChild();
            }else if(isLeftChild){
                parentNode.setLeftChild(curentNode.getRightChild());
            }else{
                parentNode.setRightChild(curentNode.getRightChild());
            }
        }else{
            Node directPostNode = this.getDirectPostNode(curentNode);
            curentNode.setValue(directPostNode.getValue());
        }
        return true;
    }

    @Override
    public Node getDirectPostNode(Node delNode) {
        Node parentNode = delNode;
        Node directPostNode = delNode;
        Node currentNode = delNode.getRightChild();
        while(currentNode != null){
            parentNode = directPostNode;
            directPostNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }

        if(directPostNode != delNode.getRightChild()){
            parentNode.setLeftChild(directPostNode.getRightChild());
            directPostNode.setRightChild(null);
        }

        return directPostNode;
    }

    @Override
    public void preOrder(Node rootNode) {
        if(rootNode != null){
            System.out.println(rootNode.getValue());
            preOrder(rootNode.getLeftChild());
            preOrder(rootNode.getRightChild());
        }
    }

    @Override
    public void inOrder(Node rootNode) {
        if(rootNode != null){
            inOrder(rootNode.getLeftChild());
            System.out.println(rootNode.getValue());
            inOrder(rootNode.getRightChild());
        }
    }

    @Override
    public void postOrder(Node rootNode) {
        if(rootNode != null){
            postOrder(rootNode.getLeftChild());
            postOrder(rootNode.getRightChild());
            System.out.println(rootNode.getValue());
        }
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
class Node{
    private int value;
    private Node leftChild;
    private Node rightChild;


    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }


}
