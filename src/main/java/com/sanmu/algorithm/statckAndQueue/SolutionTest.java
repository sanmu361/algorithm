package com.sanmu.algorithm.statckAndQueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-17 11:02
 **/
public class SolutionTest {

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        //压入第一个柱状图的下标
        stack.push(0);
        int i = 1;
        int max = heights[0];
        //当i < heights.length 或者栈不为空时，这里之所以需要判断栈不为空，是因为
        //可能有些高度很小的柱状图，一直停留在栈中，没有机会pop出来计算面积，所以最后需要一一的pop出来
        //计算面积
        while (i < heights.length || (i == heights.length && !stack.isEmpty())) {
            //当当前的高度大于大于栈顶的高度或者栈为空时，将当前的下标压栈
            if (i < heights.length && (stack.isEmpty() || heights[stack.peek()] <= heights[i])) {
                stack.push(i);
                i++;
            } else { //计算面积
                int top = heights[stack.pop()]; //得到栈顶的高度
                //计算面积，当当前的栈为空时，直接是top * i（i里面已经包含了中间被pop出去的柱状图）；不为空时，
                //则使用相对位置计算
                int currMax = !stack.isEmpty() ? (i - stack.peek() - 1) * top : top * i;
                //更新最大值
                max = Math.max(max, currMax);
            }
        }

        return max;
    }
}
