package com.sanmu.algorithm.tree;

import java.util.ArrayList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-07 10:34
 **/
public class Solution1 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;

        boolean d[] = new boolean[2];

        System.out.println(sumNumbers(a));

    }

    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        int result = root.val;

        int left = 0;
        if(root.left != null){
            left = sumNumbers(root.left,result);
        }
        int right = 0;
        if(root.right != null){
            right = sumNumbers(root.right,result);
        }

        if(root.left == null && root.right == null){
            return result;
        }

        return left + right;
    }

    public static int sumNumbers(TreeNode root,int result){
        if(root == null){
            return result;
        }
        result *= 10;
        result += root.val;
        int left = 0;
        if(root.left != null){
            left = sumNumbers(root.left,result);
        }
        int right = 0;
        if(root.right != null){
            right = sumNumbers(root.right,result);
        }

        if(root.left == null && root.right == null){
            return result;
        }
        return left + right;
    }



}


