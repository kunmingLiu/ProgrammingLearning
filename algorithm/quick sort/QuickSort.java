package com.liu.programminglearning.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class QuickSort {
    public static void sort(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int i : array
                ) {
            list.add(i);
        }
        list = sort(list);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }
    private static List<Integer> sort(List<Integer> list){
        if(list.size() < 2 ){
            return list;
        }
        int pivotIndex = list.size()/2;
        int pivot = list.get(pivotIndex);
        list.remove(pivotIndex);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) <= pivot){
                less.add(list.get(i));
            }else{
                greater.add(list.get(i));
            }
        }
        result.addAll(sort(less));
        result.add(pivot);
        result.addAll(sort(greater));
        return result;
    }
}
