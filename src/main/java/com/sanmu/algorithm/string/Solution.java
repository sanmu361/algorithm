package com.sanmu.algorithm.string;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-20 10:56
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }

    public static String getPermutation(int n, int k) {


        if(n == 1 || n < 1) {
            return String.valueOf(n);
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();

        return solution( n, temp, 0,k);

    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();


        String[] paths = path.split("/");

        for(int i = 0; i < paths.length; i++){
            if(paths[i] == null || paths.length == 0 || ".".equals(paths[i])){
                continue;
            }
            if("..".equals(paths[i])){
                if(stack.isEmpty()){
                    continue;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(paths[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        if(stack.isEmpty()){
            result.append("/");
        }else{
            while(!stack.isEmpty()){
                result.insert(0,stack.pop()).insert(0,"/");
            }
        }
        return result.toString();
    }

    private static int count = 0;
    private static String solution(int n , ArrayList<Integer> temp, int step, int k){
        if(step == n){
            count++;
            if(count == k){
                StringBuilder result = new StringBuilder();
                for(int i = 0; i < temp.size(); i++){
                    result.append(temp.get(i));
                }
                return result.toString();
            }else{
                return null;
            }
        }

        for(int i = 1; i <= n; i++){
            int tempInt = i;
            if(!temp.contains(i)){
                temp.add(tempInt);
                String result = solution(n,temp,step + 1,k);
                if(result != null){
                    return result;
                }else{
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return null;
    }
}
