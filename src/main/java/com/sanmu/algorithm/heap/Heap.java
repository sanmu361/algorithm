package com.sanmu.algorithm.heap;

import org.apache.commons.collections.ComparatorUtils;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-08-22 13:46
 **/
public class Heap<T extends Comparable> {

    T arr[] = null;

    public void maxHeapfy(T a[], int i, int heapSize){
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);

        int largets = i;

        if(leftChild < heapSize && a[leftChild].compareTo(a[largets]) > 0){
            largets = leftChild;
        }
        if(rightChild < heapSize && a[rightChild].compareTo(a[largets]) > 0){
            largets = rightChild;
        }

        if(largets != i){
          T temp = a[largets];
          a[largets] = a[i];
          a[i] = temp;
          maxHeapfy(a,largets,heapSize);
        }
    }

    public void buildMaxHeapfy(T a[],int heapSize){
        this.arr = a;

        for(int i = (heapSize - 1) / 2; i >= 0; i--){
            maxHeapfy(this.arr,i,heapSize);
        }

    }

    public void push(T t){
        exRoom();
        this.arr[this.arr.length - 1] = t;
        int child = this.arr.length - 1;
        int parent = parent(child);

        while(parent != child){
            if(arr[parent].compareTo(arr[child]) < 0){
                T temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;
                child = parent;
                parent = parent(child);
            }else{
                break;
            }
        }
    }

    public T pop(){

        T result = arr[0];
       arr[0] = arr[arr.length - 1];
       arr[arr.length - 1]  = result;

       buildMaxHeapfy(arr,arr.length - 1);

        contraRoom();

        return result;
    }

    private void contraRoom(){
        T tempArr[] = this.arr;
        T newArr[] = (T[])new Object[this.arr.length - 1];

        for(int i = 0 ; i < newArr.length; i++){
            newArr[i] = tempArr[i];
        }
        this.arr = newArr;
    }

    private void exRoom(){
        T tempArr[] = this.arr;
        T newArr[] = (T[])new Object[this.arr.length + 1];

        for(int i = 0 ; i < tempArr.length; i++){
            newArr[i] = tempArr[i];
        }
        this.arr = newArr;
    }

    private int parent(int i){
        return (i  - 1) / 2;
    }
    private int leftChild(int i ){
        return 2 * i + 1;
    }

    private int rightChild(int i){
        return 2 * i + 2;
    }


}
