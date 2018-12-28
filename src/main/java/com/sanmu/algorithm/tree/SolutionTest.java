package com.sanmu.algorithm.tree;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-20 10:36
 **/
public class SolutionTest {

    public static void main(String[] args) {
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};

        int[] c = {0,1,2,3,4,5};

        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        l1.next = l2;
        ListNode l3 = new ListNode(0);
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        l3.next = l4;
        ListNode l5 = new ListNode(9);
        l4.next = l5;

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

//        buildTree(a,b);

        TreeNode result = sortedListToBST(l1);
        System.out.println(minDepth(root));
        System.out.println(result);
    }

    public static boolean isBalanced(TreeNode root) {
        if(count(root) > 0){
            return true;
        }else{
            return false;
        }
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);


        return Math.min(left,right) + 1;
    }

    public static int count(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = count(root.left);
        int right = count(root.right);

        if(Math.abs(left - right) > 1){
            return -10;
        }else{
            return Math.max(left,right) + 1;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode cur = head;
        int size = 0;

        while(cur != null){
            cur = cur.next;
            size++;
        }

        int mid = size / 2;
        int i = 0;
        ListNode preCur = head;
        cur = head;
        while(i < mid){
            preCur = cur;
            cur = cur.next;
            i++;
        }

        TreeNode root = new TreeNode(cur.val);
        preCur.next = null;

        if(mid != 0){
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(cur.next);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int length = 0;

        while(length <inorder.length && inorder[length] != preorder[0]){
            length++;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder,1,1 + length),Arrays.copyOfRange(inorder,0,length));

        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + length,preorder.length),Arrays.copyOfRange(inorder,length + 1,inorder.length));

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int mid = (0 + nums.length) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        int left = mid - 1;
        TreeNode curLeft = root;
        while(left >= 0){
            curLeft.left = new TreeNode(nums[left]);
            curLeft = curLeft.left;
            left--;
        }

        int right = mid + 1;
        TreeNode curRight = root;
        while(right < nums.length){
            curRight.right = new TreeNode(nums[right]);
            curRight = curRight.right;
            right++;
        }

        return root;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
