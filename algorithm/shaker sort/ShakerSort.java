package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 */
public class ShakerSort {
    public static void sort(int[] array){
        int left = 0;
        int right = array.length - 1;
        int shift = 0;

        while(left < right){
            for (int i = left; i < right; i++) {
                if(array[i] > array[i+1]){
                    swap(array,i,i+1);
                    shift = i;//紀錄最後一次變化index，因為可能從這個index之後，後面的都已經排序好了
                }
            }
            right = shift;
            for (int i = right; i > left ; i--) {
                if(array[i] < array[i-1]){
                    swap(array,i,i-1);
                    shift = i;
                }
            }
            left = shift;
        }
    }

    private static void swap(int[] array , int index , int swapIndex){
        int temp = array[index];
        array[index] = array[swapIndex];
        array[swapIndex] = temp;
    }
}

