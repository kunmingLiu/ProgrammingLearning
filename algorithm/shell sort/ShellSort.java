package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class ShellSort {
    public static void sort(int[] array){
        int gap = array.length/2;
        for (; gap > 0 ; gap = gap / 2) {
            for (int j = gap; j < array.length; j++) {
                insertSort(j,gap,array);
            }
        }
    }
    private static void insertSort(int start , int gap, int[] array){
        int index = start;
        for (int i = start ; i >= 0 ; i = i - gap) {
            if(array[index] < array[i]){
                swap(array,index,i);
                index = i;
            }
        }
    }
    private static void swap(int[] array , int index , int swapIndex){
        int temp = array[index];
        array[index] = array[swapIndex];
        array[swapIndex] = temp;
    }
}
