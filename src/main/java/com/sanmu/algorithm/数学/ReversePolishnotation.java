package com.sanmu.algorithm.数学;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-26 20:58
 **/
public class ReversePolishnotation {
    private static final Map<Character,Integer> priorityMap = new HashMap<Character,Integer>(){{
        put('+',0);
        put('-',0);
        put('*',1);
        put('/',1);
        put('(',0);
        put(')',0);
    }};

    public static void main(String args[]){
        solutionTree("9+(3-1)*3+10/2");
    }

    private static void solutionNums(String line){

        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            if(priorityMap.keySet().contains(line.charAt(i))){
                if(operators.isEmpty()){
                    operators.push(line.charAt(i));
                }else{
                    if(line.charAt(i) == ')'){
                        while(operators.size() > 0 && numbers.size() >= 2 && operators.peek() != '('){
                            numbers.push(caculate(numbers.pop(),operators.pop(),numbers.pop()));
                        }
                        operators.pop();
                    }else{

                        while(operators.size() > 0 && numbers.size() >= 2 && !operators.peek().equals(')') && !operators.peek().equals('(') && priorityMap.get(operators.peek()) >= priorityMap.get(line.charAt(i))){
                            numbers.push(caculate(numbers.pop(),operators.pop(),numbers.pop()));
                        }
                        operators.push(line.charAt(i));
                    }
                }
            }else{
                StringBuilder number = new StringBuilder();

                while(i < line.length() && line.charAt(i) <= '9' && line.charAt(i) >= '0' ){
                    number.append( line.charAt(i));
                    i++;
                }
                numbers.push(Integer.valueOf(number.toString()));
                i--;
            }
        }


        while (!operators.isEmpty() && numbers.size() >= 2){
            numbers.push(caculate(numbers.pop(),operators.pop(),numbers.pop()));
        }

        System.out.println(numbers.pop().toString());

    }
    private static void solutionTree(String line){
        Stack<Character> operators = new Stack<>();
        Stack<Tree> numberStack = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            if(priorityMap.keySet().contains(line.charAt(i))){
                if(operators.isEmpty()){
                    operators.push(line.charAt(i));
                }else{
                    if(line.charAt(i) == ')'){
                        while(operators.size() > 0 && numberStack.size() >= 2 && operators.peek() != '('){
                            Tree right = numberStack.pop();
                            Tree left = numberStack.pop();
                            Tree mid = new Tree(String.valueOf(operators.pop()));
                            mid.setRight(right);
                            mid.setLeft(left);
                            numberStack.push(mid);
                        }
                        operators.pop();
                    }else{

                        while(operators.size() > 0 && numberStack.size() >= 2 && !operators.peek().equals(')') && !operators.peek().equals('(') && priorityMap.get(operators.peek()) >= priorityMap.get(line.charAt(i))){
                            Tree right = numberStack.pop();
                            Tree left = numberStack.pop();
                            Tree mid = new Tree(String.valueOf(operators.pop()));
                            mid.setRight(right);
                            mid.setLeft(left);
                            numberStack.push(mid);
                        }
                        operators.push(line.charAt(i));
                    }
                }
            }else{
                StringBuilder number = new StringBuilder();

                while(i < line.length() && line.charAt(i) <= '9' && line.charAt(i) >= '0' ){
                    number.append( line.charAt(i));
                    i++;
                }
                numberStack.push(new Tree(number.toString()));
                i--;
            }
        }


        while (!operators.isEmpty() && numberStack.size() >= 2){
            Tree right = numberStack.pop();
            Tree left = numberStack.pop();
            Tree mid = new Tree(String.valueOf(operators.pop()));
            mid.setRight(right);
            mid.setLeft(left);
            numberStack.push(mid);
        }

        Gson gson = new Gson();
        Tree tree = numberStack.pop();
        shenduyouxian(tree);
        guangduyouxian(tree);
        System.out.println(gson.toJson(tree));
    }
    private static void solutionPolinsh(String line){
        Stack<Character> operators = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < line.length(); i++){
            if(priorityMap.keySet().contains(line.charAt(i))){
                if(operators.isEmpty()){
                    operators.push(line.charAt(i));
                }else{
                    if(line.charAt(i) == ')'){
                        while(operators.size() > 0 && operators.peek() != '('){
                            result.append(operators.pop()).append(" ");
                        }
                        operators.pop();
                    }else{

                        while(operators.size() > 0 && !operators.peek().equals(')') && !operators.peek().equals('(') && priorityMap.get(operators.peek()) >= priorityMap.get(line.charAt(i))){
                            result.append(operators.pop()).append(" ");
                        }
                        operators.push(line.charAt(i));
                    }
                }
            }else{
                StringBuilder number = new StringBuilder();

                while(i < line.length() && line.charAt(i) <= '9' && line.charAt(i) >= '0' ){
                    number.append( line.charAt(i));
                    i++;
                }
                result.append(number).append(" ");
                i--;
            }
        }


        while (!operators.isEmpty()){
            result.append(operators.pop()).append(" ");
        }

        System.out.println(result.toString());
    }


    private static void shenduyouxian(Tree root){
        if(root.getLeft() != null){
            shenduyouxian(root.left);
        }
        if(root.getRight() != null){
            shenduyouxian(root.right);
        }
        System.out.println(root.value);
    }

    private static void guangduyouxian(Tree root){

        LinkedList<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while(!queue.isEmpty()){
            Tree temp = queue.pop();
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }
            System.out.println(temp.getValue());
        }

    }

    private static class Tree{
        private Tree left;
        private Tree right;
        private String value;

        public Tree(String value) {
            this.value = value;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public void setRight(Tree right) {
            this.right = right;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Tree getLeft() {
            return left;
        }

        public Tree getRight() {
            return right;
        }

        public String getValue() {
            return value;
        }
    }

    private static Integer caculate(Integer a, Character c ,Integer b){
        Integer result = 0;
        if(c == '+'){
            result = a + b;
        }else if(c == '-'){
            result = b - a;
        }else if(c == '*'){
            result = a * b;
        }else if(c == '/'){
            result = b / a;
        }
        return result;
    }
}