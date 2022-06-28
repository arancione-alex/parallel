package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long start;
        long end;
        //int threads = 1;
        int[][][] matrixes1 = generateMatrix(20,20,1000);
        int[][][] matrixes2 = generateMatrix(200,200,500);
        String dir = "D:/JavaProjects/mitpp1/resources/";

        MultiThreadMultiply.mul(matrixes1,10);//cold start cpu
        MultiThreadMultiply.mul(matrixes2,10);//cold start memory
        for(int threads = 1; threads<=10;threads++){
            start=System.currentTimeMillis();
            MultiThreadMultiply.mul(matrixes1,threads);
            end = System.currentTimeMillis();
            System.out.println("CPU estimated time for "+threads+" threads is "+(end-start)+" ms");
        }
        for(int threads = 1; threads<=10;threads++){
            start=System.currentTimeMillis();
            MultiThreadMultiply.mul(matrixes2,threads);
            end = System.currentTimeMillis();
            System.out.println("Memory estimated time for "+threads+" threads is "+(end-start)+" ms");
        }
        for(int threads = 1; threads<=10;threads++){                                 //cold start io
            MultiThreadIO.execute(threads,dir+String.valueOf(threads)+"/");
        }
        for(int threads = 1; threads<=10;threads++){
            start=System.currentTimeMillis();
            MultiThreadIO.execute(threads,dir+String.valueOf(threads)+"/");
            end = System.currentTimeMillis();
            System.out.println("IO estimated time for "+threads+" threads is "+(end-start)+" ms");
        }

    }
    public static int[][][] generateMatrix(int m, int n, int matrixAmount) {
        Random random = new Random();
        int[][][] arrays = new int[matrixAmount][m][n];
        for (int k = 0; k < matrixAmount; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arrays[k][i][j] = random.nextInt(101) + 1000;
                }
            }
        }
        return arrays;
    }
}
