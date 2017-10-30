package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class InsertionSort {
    public static void sort(int[] array){
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            index = i;
            for (int j = i - 1; j >= 0; j--) {
                if(array[index] < array[j]){
                    swap(array,index,j);
                    index = j;
                }
            }
        }
    }
    private static void swap(int[] array , int index , int swapIndex){
        int temp = array[index];
        array[index] = array[swapIndex];
        array[swapIndex] = temp;
    }
}

