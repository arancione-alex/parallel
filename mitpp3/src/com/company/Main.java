package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int iterations = 200;
        long timeMs = 2000;
        int cells = 20;
        int parts = 6;
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
        for(int z = 0; z< crystal.size();z++){
            System.out.println(Arrays.toString(crystal.get(z)));
        }
        System.out.println("-------------");
        //MultipleThreadIterationMove.iterationMove(crystal,iterations);
        MulltipleThreadTimeMove.timeMove(crystal,timeMs);
        for(int z = 0; z< crystal.size();z++){
            System.out.println(Arrays.toString(crystal.get(z)));
        }

    }
}
