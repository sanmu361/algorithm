package com.sanmu.algorithm.数学;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-06 11:02
 **/
public class SolutionTest {

    public static void main(String[] args) {
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(a));
    }

    public static int trap(int[] height) {
        int max = 0;
        int maxIndex = 0;
        for(int i =0 ;i< height.length; i++){
            if (max < height[i]){
                max = height[i];
                maxIndex = i;
            }
        }

        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int a=0 ; a<maxIndex; a++){
            if (height[a]>=maxLeft){
                maxLeft = height[a];
            }
            else{
                sum+= maxLeft-height[a];
            }
        }

        for (int b=height.length-1 ; b>maxIndex; b--){
            if (height[b]>=maxRight){
                maxRight = height[b];
            }
            else{
                sum+= maxRight-height[b];
            }
        }

        return sum;
    }

}
