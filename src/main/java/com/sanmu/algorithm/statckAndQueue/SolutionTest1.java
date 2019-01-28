package com.sanmu.algorithm.statckAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-18 10:42
 **/
public class SolutionTest1 {

    public static void main(String[] args) {
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(5);
        TreeNode t34 = new TreeNode(6);

        TreeNode t21 = new TreeNode(2);
        t21.left = t31;
        t21.right = t32;
        TreeNode t22 = new TreeNode(-1);
        t22.left = t33;
        t22.right = t34;

        TreeNode t1 = new TreeNode(1);
        t1.left = t21;
        t1.right = t22;

//        zigzagLevelOrder(t1);

        System.out.println(Integer.toBinaryString(5));

        System.out.println(rangeBitwiseAnd(5,7));

        System.out.println(0&0);

        rightSideView(t1);

        StringBuilder a = new StringBuilder();

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> curQueue = null;
        queue.add(root.left);
        queue.add(root.right);
        queue.clear();
        int i = 2;
        while(queue.size() > 0){
            if(queue.size() == Math.pow(2D,i - 1)){
                curQueue = queue;
                queue = new LinkedList<TreeNode>();
                LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
                LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
                while(curQueue.size() > 0){
                    TreeNode first = curQueue.pollFirst();
                    TreeNode last = curQueue.pollLast();
                    if(first.val != last.val){
                        return false;
                    }

                    if(first.left !=null){
                        q1.add(first.left);
                    }
                    if(first.right != null){
                        q1.add(first.right);
                    }
                    if(last.right != null){
                        q2.addFirst(last.right);
                    }
                    if(last.left != null){
                        q2.addFirst(last.left);
                    }
                    queue.addAll(q1);
                    queue.addAll(q2);
                }
                i++;
            }else{
                return false;
            }
        }

        return true;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root != null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> curQueue = new LinkedList<TreeNode>();
        List<Integer> tempList = new ArrayList<Integer>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            tempList.add(temp.val);

            if(temp.left != null){
                curQueue.add(temp.left);
            }

            if(temp.right != null){
                curQueue.add(temp.right);
            }

            if(queue.isEmpty()){
                queue = curQueue;
                if(tempList.size() > 0){
                    result.add(tempList);
                }
                tempList = new ArrayList<Integer>();
                curQueue = new LinkedList<TreeNode>();
            }
        }

        return result;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if(root == null){
            return result;
        }


        result.add(root.val);

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.pop();

            if(t.left != null){
                temp.offer(t.left);
            }
            if(t.right != null){
                temp.offer(t.right);
            }

            if(queue.isEmpty()){

                if(!temp.isEmpty()){
                    result.add(temp.getLast().val);
                }
                queue = temp;
                temp = new LinkedList();
            }
        }
        return result;
    }

    public static int rangeBitwiseAnd(int m, int n) {
        String mS = Integer.toBinaryString(m);
        String nS = Integer.toBinaryString(n);

        if(mS.length() != nS.length()){
            return 0;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < mS.length(); i++){
            if(mS.charAt(i) == nS.charAt(i)){
                result.append(nS.charAt(i));
            }else{
                for(;i < mS.length(); i++)
                    result.append(0);
                break;
            }
        }

        return Integer.parseInt(result.toString(),2);
    }
}

class TreeNode {
    int val;
    TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
