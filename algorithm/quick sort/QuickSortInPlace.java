package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class QuickSortInPlace {
    public static void sort(int[] array){
        sort(array, 0 , array.length-1);
    }
    private static void sort(int[] array , int left , int right){

        if( left >= right){
            return;
        }
        int pivotIndex = (left+right)/2;
        int pivot = array[pivotIndex];
        int swapIndex = left;

        swap(array, pivotIndex, right);
        for(int i = left ; i < right ; i ++){
            if(array[i] <= pivot){
                swap(array,i,swapIndex);
                swapIndex++;
            }
        }
        swap(array,swapIndex,right);

        sort(array,left,swapIndex-1);
        sort(array,swapIndex+1,right);
    }
    private static void swap(int[] array , int index, int swapIndex){
        int temp = array[index];
        array[index] = array[swapIndex];
        array[swapIndex] = temp;
    }
}