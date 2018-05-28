package com.sanmu.algorithm.greedy;

import com.google.common.base.Splitter;

import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-21 17:21
 **/
public class CrossList {

    public static void main(String[] args) {

        System.out.println(solution("aabcc,dbbca,aadbbcbca"));

    }

    private static String solution(String line){
        String Strs[] = line.split(",");

        if(Strs.length != 3){
            return "false";
        }

        String a = Strs[0];
        String b = Strs[1];

        String c = Strs[2];

        int i = 0,j = 0;

        for( ; i < a.length() && j < b.length() && (i + j) < c.length(); ){
            if( a.charAt(i) == c.charAt(i + j) && b.charAt(j) == c.charAt(i + j)){
                if(i < j){
                    i++;
                }else{
                    j++;
                }
                continue;
            }
            else if(a.charAt(i) == c.charAt(i + j)){
                i++;
                continue;
            }
            else if (b.charAt(j) == c.charAt(i + j)){
                j++;
                continue;
            }else{
                return "false";
            }
        }

       while(i < a.length() && (i + j) < c.length() ){
           if(a.charAt(i) == c.charAt(i + j)){
               i++;
           }else{
               break;
           }
       }
       while(j < b.length() && (i + j) < c.length() ){
           if(b.charAt(j) == c.charAt(i + j)){
               j++;
           }else{
               break;
           }
        }

        if(i != a.length() || j != b.length() ){
            return "false";
        }

        if((i + j) == c.length()){
            return "true";
        }
        return "false";
    }
}
