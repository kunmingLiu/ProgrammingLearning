package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class BubbleSort {
    public static void sort(int[] array){
        boolean isSwap = true;
        for (int i = 0; i < array.length - 1 && isSwap == true; i++) {
            isSwap = false;
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j+1]){
                    isSwap = true;
                    swap(array,j,j+1);
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