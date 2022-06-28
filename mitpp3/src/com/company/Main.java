package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int iterations = 10000;
        long timeMs = 200;
        long delay = 10;
        int cells = 10;
        int parts = 8;

        List<int[]> crystal = new ArrayList<>();
        for(int i = 0; i<cells;i++){
            int[] cell = new int[parts];
            if(i==0){
                Arrays.fill(cell, 1);
                crystal.add(cell);
            }
            else {
                Arrays.fill(cell, 0);
                crystal.add(cell);
            }
        }
        //MultipleThreadIterationMove.iterationMove(crystal,iterations);// cold start
        MulltipleThreadTimeMove.timeMove(crystal,timeMs,delay);


            List<int[]> crystal1 = new ArrayList<>();
            for(int i = 0; i<cells;i++){
                int[] cell = new int[10];
                if(i==0){
                    Arrays.fill(cell, 1);
                    crystal1.add(cell);
                }
                else {
                    Arrays.fill(cell, 0);
                    crystal1.add(cell);
                }
            }
//            long start = System.currentTimeMillis();
//            MultipleThreadIterationMove.iterationMove(crystal,iterations);
//            long end = System.currentTimeMillis();
//            System.out.println("Estimated time for "+10+" threads is "+(end-start)+" ms");
        System.out.println("---------------");
        showRes(crystal);
    }
    public static void showRes(List<int[]> crystal){
        List<Integer> res = new ArrayList<>();
        for(int z = 0; z< crystal.size();z++){
            int sum = 0;
            for(int j = 0; j<crystal.get(z).length;j++){
                sum += crystal.get(z)[j];
            }
            res.add(sum);
        }
        System.out.println(res);
    }
}
