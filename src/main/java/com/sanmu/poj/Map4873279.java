package com.sanmu.poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-24 11:45
 **/
public class Map4873279 {

    private static final Map<Character,Integer> map = new HashMap<Character, Integer>(){
        {
            put('A',2);
            put('B',2);
            put('C',2);
            put('D',3);
            put('E',3);
            put('F',3);
            put('G',4);
            put('H',4);
            put('I',4);
            put('J',5);
            put('K',5);
            put('L',5);
            put('M',6);
            put('N',6);
            put('O',6);
            put('P',7);
            put('R',7);
            put('S',7);
            put('T',8);
            put('U',8);
            put('V',8);
            put('W',9);
            put('X',9);
            put('Y',9);
        }
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        Map<String,Integer> result = new TreeMap<String,Integer>();
        while(num-- > 0){
            String line = scanner.nextLine();

            String key = solution(line);
           if(result.get(key) != null) {
               result.put(key,result.get(key) + 1);
            }else{
               result.put(key,1);
           }
        }

        for(String k : result.keySet()){
                System.out.println(k + " " + result.get(k));
        }
    }

    private static String solution(String line){
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < line.length(); i++){
            char c = line.charAt(i);
            if(c >= '0' && c <= '9'){
                result.append(c);
            }else if(c >= 'A' && c <= 'Z'){
                result.append(map.get(c));
            }
        }

        result.insert(3,"-");

        return result.toString();
    }
}
