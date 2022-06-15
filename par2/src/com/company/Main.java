package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        int threadsCount = 4;

        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i< 100; i++){
            list.add(random.nextInt(100));
        }

        int limit = list.size()/threadsCount;
        List<List<Integer>> listList = chopped(list,limit);
        System.out.println(listList.get(3));
        List<Object[]> listArr = new ArrayList<>();
        for(int i = 0; i < listList.size();i++){
            listArr.add(i,listList.get(i).toArray());
        }

        listArr.forEach(ll ->new Thread(() -> Sorter(listArr.));

    }
    static <T> List<List<T>> chopped(List<T> list,  int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }


}
