package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Sorter implements Runnable {
    int i = 1;
    int arr[];
    public static int[] countingSort(int[] theArray, int maxValue) {
        int numCounts[] = new int[maxValue + 1];
        for (int num : theArray) {
            numCounts[num]++;
        }
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
    public static int[] quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
        return source;
    }
    public static int[] standartSort(int[] a){
       Arrays.sort(a);
       return a;
    }

    public Sorter(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        List<Object[]> listArr = new ArrayList<>();
        for(int i = 0; i < listList.size();i++){
            listArr.add(i,listList.get(i).toArray());
        }
        long start;
        long end;
        if (i%2==0){
            start = System.currentTimeMillis();
            countingSort(listList.get(i),100);
            end = System.currentTimeMillis();
            System.out.println("Counting sorting time is"+ (end-start)+"ms");
            i++;
        }
        else if(i%3==0){
            start = System.currentTimeMillis();
            quickSort(arr, arr[0], arr[arr.length-1]);
            end = System.currentTimeMillis();
            System.out.println("Quick sorting time is"+ (end-start)+"ms");
            i++;
        }
        else {
            start = System.currentTimeMillis();
            standartSort(arr);
            end = System.currentTimeMillis();
            System.out.println("Standart sorting time is"+ (end-start)+"ms");
            i++;
        }

    }
}
