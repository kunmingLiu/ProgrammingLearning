package com.liu.programminglearning.algorithm.sort;

/**
 * Created by kunmingliu on 2017/10/30.
 * Radix Sort(LSD)
 */
public class RadixSort {
    public static void sort(int[] array){
        int[][] buckets = new int[10][array.length];
        int[] counts = new int[array.length < 10 ? 10 : array.length];
        int radix = 1;
        int max = 1;
        int lsd ;
        boolean isFirst = false;
        int index = 0;
        while(max / radix != 0){
            for (int i = 0; i < array.length; i++) {
                lsd = (array[i]/radix) % 10;
                buckets[lsd][counts[lsd]] = array[i];
                counts[lsd]++;
                if(!isFirst) {
                    max = Math.max(max, array[i]);
                }
            }
            isFirst = true;

            index  = 0;
            for (int i = 0; i < 10; i++) {
                if(counts[i] != 0){
                    for (int j = 0; j < counts[i]; j++) {
                        array[index++] = buckets[i][j];
                    }
                }
                counts[i] = 0;
            }
            radix = radix * 10;
        }
    }
}

