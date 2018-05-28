package com.sanmu.algorithm.string;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-22 15:23
 **/
public class Manacher {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        sc.nextLine();
//        while(num-- > 0){
//            String line = sc.nextLine();
//            System.out.println(solution(line));
//        }

        System.out.println(solution1("aaaabbaa"));
    }

    private static int solution(String line){

        int length = line.length();

        StringBuilder stringBuilder = new StringBuilder(line);
        for(int i = 0,k = 1; i < length - 1; i++,k = k + 2 ){
            stringBuilder.insert(k,"#");
        }

        length = stringBuilder.length();

        int nums[] = new int[length];

        nums[0] = 0;

        for(int i = 1,j = 1,k ; i < length; i = i + k){
            while(i - j >= 0 && i + j < length && stringBuilder.charAt(i - j) == stringBuilder.charAt(i + j)){
                j++;
            }
            nums[i] = j - 1;
            for(k = 1; k < nums[i] && nums[i - k] != nums[i] - k; k++){
                nums[i + k] = Math.min(nums[i - k],nums[i] - k);
            }
            j = Math.max(j- k,0);
        }

        int max = 0;
        int center = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] > max){
                max = nums[i];
                center = i;
            }
        }
        if(max >= 2){
            System.out.println(stringBuilder.substring(center - max,center + max + 1));
            return stringBuilder.substring(center - max,center + max + 1).replace("#","").length();
        }

        return 1;
    }

    private static int LPS(String line) {
        int length = line.length();
        char[] newLine = new char[length * 2];
        for(int i = 0,j = 0; i < length;i++){
           newLine[j++] = line.charAt(i);
           newLine[j++] = '#';
        }

        length = newLine.length;

        int nums[] = new int[length];

        int id = 0;//记录已经查找过的边界最靠右回文串的中心
        int maxLPS = 1;

        nums[0] = 1;

        for(int i = 1; i < length; i++){
            if (nums[id] + id - 1 >= i)
                nums[i] = Math.min(nums[2 * id - i], nums[id] + id - i);
            else
                nums[i] = 1;

            while (i - nums[i] >= 0 && i + nums[i] < length && newLine[i - nums[i]] == newLine[i + nums[i]]){
                ++nums[i];
            }

            if(nums[i] > 1 && newLine[i - (nums[i] - 1)] == '#'){
                nums[i]--;
            }

            if (nums[id] + id < nums[i] + i)
                id = i;
            if (nums[i]>maxLPS)
                maxLPS = nums[i];
        }
        return  maxLPS;
    }

    private static int solution1(String line){
        char[] newLines = new char[line.length() * 2];

        for(int i = 0,j = 0; i < line.length(); i++){
            newLines[j++] = line.charAt(i);
            newLines[j++] = '#';
        }

        int nums[] = new int[newLines.length];
        int id = 0;


        for(int i = 0; i < newLines.length; i++){
            if(id + nums[i] - 1 >= i){
                nums[i] = Math.min(nums[2 * id - i],nums[id] - 2 * (i - id));
            }else{
                nums[i] = 1;
            }

            while(i - nums[i] >= 0 && i + nums[i] < newLines.length && newLines[i - nums[i]] == newLines[i + nums[i]]){
                nums[i]++;
            }

            if(nums[i] > nums[id]){
                id = i;
            }
            if(newLines[i - nums[i] + 1] == '#'){
                nums[i]--;
            }
        }
        return nums[id];
    }
}
