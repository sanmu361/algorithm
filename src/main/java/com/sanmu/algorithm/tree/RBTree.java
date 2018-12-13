package com.sanmu.algorithm.tree;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;
import org.apache.commons.collections.ComparatorUtils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-05 13:55
 **/
public class RBTree<T extends Comparable<T>> {

    private RBNode<T> root = new RBNode<T>(null);

    private AtomicLong size = new AtomicLong(0);

    private volatile boolean overrideMode = true;

    public RBTree(){
    }

    public AtomicLong getSize() {
        return size;
    }

    public boolean isOverrideMode() {
        return overrideMode;
    }

    public void setSize(AtomicLong size) {
        this.size = size;
    }

    public void setOverrideMode(boolean overrideMode) {
        this.overrideMode = overrideMode;
    }

    public void setRoot(RBNode<T> root) {
        this.root = root;
    }

    public RBNode<T> getRoot() {
        return root.getLeft();
    }

    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<Integer>();

        for(int i = 0 ; i < 10; i++){
            tree.addNode(i);
        }
        System.out.println(tree);
    }

   public T addNode(T value){
        RBNode<T> t = new RBNode<T>(value);
        return addNode(t);
   }

   private T addNode(RBNode<T> node){
        node.setLeft(null);
        node.setRight(null);
        node.setRed(true);
        setParent(node,null);

        if(root.getLeft() == null){
            root.setLeft(node);
            node.setRed(false);
            size.incrementAndGet();
        }else{
            RBNode<T> x = findParentNode(node);
            int cmp = x.getValue().compareTo(node.getValue());

            if(this.overrideMode && cmp == 0){
                T v = x.getValue();
                x.setValue(node.getValue());
                return v;
            }else if(cmp == 0){
                return x.getValue();
            }
            setParent(node,x);
            if(cmp > 0){
                x.setLeft(node);
            }else{
                x.setRight(node);
            }

            fixInsert(node);
            size.incrementAndGet();
        }
        return null;
   }

   private RBNode<T> findParentNode(RBNode<T> x){
        RBNode<T> dataRoot = getRoot();
        RBNode<T> child = dataRoot;

        while(child != null){
            int cmp = child.getValue().compareTo(x.getValue());
            if(cmp == 0){
                return child;
            }else if(cmp > 0){
                dataRoot = child.getLeft();
                child = child.getLeft();
            }else{
                dataRoot = child;
                child = child.getRight();
            }
        }
        return dataRoot;
   }

   private void fixInsert(RBNode<T> x){
        RBNode<T> parent = x.getParent();

        while(parent != null && parent.isRed()){
            RBNode<T> uncle = getUncle(x);
            if(uncle == null){
                RBNode<T> ancestor = parent.getParent();
                if(parent == ancestor.getLeft()){
                    boolean isRight = x == parent.getRight();
                    if(isRight){
                        rotateLeft(parent);
                    }
                    rotateRight(ancestor);

                    if(isRight){
                        x.setRed(false);
                        parent = null;
                    }else{
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }else{
                    boolean isLeft = x == parent.getLeft();
                    if(isLeft){
                        rotateRight(parent);
                    }
                    rotateLeft(ancestor);

                    if(isLeft){
                        x.setRed(false);
                        parent=null;//end loop
                    }else{
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }
            }else{
                parent.setRed(false);
                uncle.setRed(false);
                parent.getParent().setRed(true);
                x=parent.getParent();
                parent = x.getParent();
            }
        }
        getRoot().makeBlack();
        getRoot().setParent(null);
   }

   private RBNode<T> getUncle(RBNode<T> node){
        RBNode<T> parent = node.getParent();
        RBNode<T> ancestor = parent.getParent();

        if(ancestor == null){
            return null;
        }
        if(parent == ancestor.getLeft()){
            return ancestor.getRight();
        }else{
            return ancestor.getLeft();
        }
   }

   private void setParent(RBNode<T> node,RBNode<T> parent){
        if(node != null){
            node.setParent(parent);
            if(parent == root){
                node.setParent(null);
            }
        }
   }

    private void rotateLeft(RBNode<T> node){
        RBNode<T> right = node.getRight();
        if(right==null){
            throw new java.lang.IllegalStateException("right node is null");
        }
        RBNode<T> parent = node.getParent();
        node.setRight(right.getLeft());
        setParent(right.getLeft(),node);

        right.setLeft(node);
        setParent(node,right);

        if(parent==null){//node pointer to root
            //right  raise to root node
            root.setLeft(right);
            setParent(right,null);
        }else{
            if(parent.getLeft()==node){
                parent.setLeft(right);
            }else{
                parent.setRight(right);
            }
            //right.setParent(parent);
            setParent(right,parent);
        }
    }

    private void rotateRight(RBNode<T> node){
        RBNode<T> left = node.getLeft();
        if(left==null){
            throw new java.lang.IllegalStateException("left node is null");
        }
        RBNode<T> parent = node.getParent();
        node.setLeft(left.getRight());
        setParent(left.getRight(),node);

        left.setRight(node);
        setParent(node,left);

        if(parent==null){
            root.setLeft(left);
            setParent(left,null);
        }else{
            if(parent.getLeft()==node){
                parent.setLeft(left);
            }else{
                parent.setRight(left);
            }
            setParent(left,parent);
        }
    }

   public T find(T value){
       RBNode<T> dataRoot = getRoot();
       while(dataRoot!=null){
           int cmp = dataRoot.getValue().compareTo(value);
           if(cmp<0){
               dataRoot = dataRoot.getRight();
           }else if(cmp>0){
               dataRoot = dataRoot.getLeft();
           }else{
               return dataRoot.getValue();
           }
       }
       return null;
   }

    public T remove(T value){
        RBNode<T> dataRoot = getRoot();
        RBNode<T> parent = root;

        while(dataRoot!=null){
            int cmp = dataRoot.getValue().compareTo(value);
            if(cmp<0){
                parent = dataRoot;
                dataRoot = dataRoot.getRight();
            }else if(cmp>0){
                parent = dataRoot;
                dataRoot = dataRoot.getLeft();
            }else{
                if(dataRoot.getRight()!=null){
                    RBNode<T> min = removeMin(dataRoot.getRight());
                    //x used for fix color balance
                    RBNode<T> x = min.getRight()==null ? min.getParent() : min.getRight();
                    boolean isParent = min.getRight()==null;

                    min.setLeft(dataRoot.getLeft());
                    setParent(dataRoot.getLeft(),min);
                    if(parent.getLeft()==dataRoot){
                        parent.setLeft(min);
                    }else{
                        parent.setRight(min);
                    }
                    setParent(min,parent);

                    boolean curMinIsBlack = min.isBlack();
                    //inherit dataRoot's color
                    min.setRed(dataRoot.isRed());

                    if(min!=dataRoot.getRight()){
                        min.setRight(dataRoot.getRight());
                        setParent(dataRoot.getRight(),min);
                    }
                    //remove a black node,need fix color
                    if(curMinIsBlack){
                        if(min!=dataRoot.getRight()){
                            fixRemove(x,isParent);
                        }else if(min.getRight()!=null){
                            fixRemove(min.getRight(),false);
                        }else{
                            fixRemove(min,true);
                        }
                    }
                }else{
                    setParent(dataRoot.getLeft(),parent);
                    if(parent.getLeft()==dataRoot){
                        parent.setLeft(dataRoot.getLeft());
                    }else{
                        parent.setRight(dataRoot.getLeft());
                    }
                    //current node is black and tree is not empty
                    if(dataRoot.isBlack() && !(root.getLeft()==null)){
                        RBNode<T> x = dataRoot.getLeft()==null
                                ? parent :dataRoot.getLeft();
                        boolean isParent = dataRoot.getLeft()==null;
                        fixRemove(x,isParent);
                    }
                }
                setParent(dataRoot,null);
                dataRoot.setLeft(null);
                dataRoot.setRight(null);
                if(getRoot()!=null){
                    getRoot().setRed(false);
                    getRoot().setParent(null);
                }
                size.decrementAndGet();
                return dataRoot.getValue();
            }
        }
        return null;
    }

    private void fixRemove(RBNode<T> node,boolean isParent){
        RBNode<T> cur = isParent ? null : node;
        boolean isRed = isParent ? false : node.isRed();
        RBNode<T> parent = isParent ? node : node.getParent();

        while(!isRed && !isRoot(cur)){
            RBNode<T> sibling = getSibling(cur,parent);
            //sibling is not null,due to before remove tree color is balance

            //if cur is a left node
            boolean isLeft = parent.getRight()==sibling;
            if(sibling.isRed() && !isLeft){//case 1
                //cur in right
                parent.makeRed();
                sibling.makeBlack();
                rotateRight(parent);
            }else if(sibling.isRed() && isLeft){
                //cur in left
                parent.makeRed();
                sibling.makeBlack();
                rotateLeft(parent);
            }else if(isBlack(sibling.getLeft()) && isBlack(sibling.getRight())){//case 2
                sibling.makeRed();
                cur = parent;
                isRed = cur.isRed();
                parent=parent.getParent();
            }else if(isLeft && !isBlack(sibling.getLeft())
                    && isBlack(sibling.getRight())){//case 3
                sibling.makeRed();
                sibling.getLeft().makeBlack();
                rotateRight(sibling);
            }else if(!isLeft && !isBlack(sibling.getRight())
                    && isBlack(sibling.getLeft()) ){
                sibling.makeRed();
                sibling.getRight().makeBlack();
                rotateLeft(sibling);
            }else if(isLeft && !isBlack(sibling.getRight())){//case 4
                sibling.setRed(parent.isRed());
                parent.makeBlack();
                sibling.getRight().makeBlack();
                rotateLeft(parent);
                cur=getRoot();
            }else if(!isLeft && !isBlack(sibling.getLeft())){
                sibling.setRed(parent.isRed());
                parent.makeBlack();
                sibling.getLeft().makeBlack();
                rotateRight(parent);
                cur=getRoot();
            }
        }
        if(isRed){
            cur.makeBlack();
        }
        if(getRoot()!=null){
            getRoot().setRed(false);
            getRoot().setParent(null);
        }
    }

    //get sibling node
    private RBNode<T> getSibling(RBNode<T> node,RBNode<T> parent){
        parent = node==null ? parent : node.getParent();
        if(node==null){
            return parent.getLeft()==null ? parent.getRight() : parent.getLeft();
        }
        if(node==parent.getLeft()){
            return parent.getRight();
        }else{
            return parent.getLeft();
        }
    }

    private boolean isBlack(RBNode<T> node){
        return node==null || node.isBlack();
    }
    private boolean isRoot(RBNode<T> node){
        return root.getLeft() == node && node.getParent()==null;
    }
    /**
     * find the successor node
     * @param node current node's right node
     * @return
     */
    private RBNode<T> removeMin(RBNode<T> node){
        //find the min node
        RBNode<T> parent = node;
        while(node!=null && node.getLeft()!=null){
            parent = node;
            node = node.getLeft();
        }
        //remove min node
        if(parent==node){
            return node;
        }

        parent.setLeft(node.getRight());
        setParent(node.getRight(),parent);

        //don't remove right pointer,it is used for fixed color balance
        //node.setRight(null);
        return node;
    }
}

class RBNode<T extends Comparable<T>>{
    private T value;
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> parent;
    private boolean red;

    public RBNode(T value) {
        this.value = value;
    }

    public RBNode(T value,boolean isRed) {
        this.value = value;
        this.red = isRed;
    }

    public T getValue() {
        return value;
    }

    public RBNode<T> getLeft() {
        return left;
    }

    public RBNode<T> getRight() {
        return right;
    }

    public RBNode<T> getParent() {
        return parent;
    }

    public boolean isRed() {
        return red;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(RBNode<T> left) {
        this.left = left;
    }

    public void setRight(RBNode<T> right) {
        this.right = right;
    }

    public void setParent(RBNode<T> parent) {
        this.parent = parent;
    }

    public void setRed(boolean red) {
        this.red = red;
    }
    public void makeBlack(){
        red=false;
    }

    public boolean isBlack(){
        return !red;
    }

    public void makeRed(){
        red=true;
    }
}
