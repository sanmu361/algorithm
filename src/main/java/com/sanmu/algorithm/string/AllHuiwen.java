package com.sanmu.algorithm.string;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-10-15 13:14
 **/
public class AllHuiwen {

    public static void main(String[] args) {
        String s="aaab";
        AllHuiwen sol=new AllHuiwen();
        System.out.println(sol.partition(s));
    }

    public void solution(String a){
        int size = a.length();

        List<List<Boolean>> p = Lists.newArrayList();


    }

    //获得一个字符串的所有回文子串集合
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>>arr=new ArrayList<ArrayList<String>>();
        if(s==null||s.length()==0){
            return arr;
        }
        ArrayList<String> list=new ArrayList<String>();
        dfs(0,s,list,arr);
        return arr;
    }
    //回溯法
    private void dfs(int index,String s,ArrayList<String> preList, ArrayList<ArrayList<String>>arr)
    {
        if(index==s.length()){
            arr.add(new ArrayList<String>(preList));
            return;
        }
        ArrayList<String> list = new ArrayList<String>(preList);
        for(int i=index;i!=s.length();i++){
            if(isHui(s,index,i))
            {
                list.add(s.substring(index,i+1));
                dfs(i+1,s,list,arr); //递归调用
                list.remove(list.size()-1);
            }
        }
        System.out.println(list);
    }
    //判断是否为回文串
    private boolean isHui(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
            {
                return false;
            }
        }
        return true;
    }
}
