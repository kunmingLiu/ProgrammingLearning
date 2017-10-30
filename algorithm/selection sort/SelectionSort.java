package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 */
public class SelectionSort {
    public static void sort(int[] array){
        int min = 0;
        for(int i = 0 ; i < array.length - 1; i ++){
            min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min] > array[j]){
                    min = j;
                }
            }
            if(array[min] != array[i]){
                swap(array,i,min);
            }
        }
    }
    private static void swap(int[] array , int index , int swapIndex){
        int temp = array[index];
        array[index] = array[swapIndex];
        array[swapIndex] = temp;
    }
}

