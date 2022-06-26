package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixWork {
    public static int[][] multiplyMatrixes(int[][] firstMatrix, int[][] secondMatrix) {
        int m = firstMatrix.length;
        int n = secondMatrix[0].length;
        int o = secondMatrix.length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return res;
    }
    public static int[][] generateMatrix(int a, int b){
        int[][] arr = new int[a][b];
        Random rand = new Random();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = rand.nextInt(100) + 1;
            }
        }
        return arr;
    }
    public static List<int[]> findElement(int[][] arr, int el){
        List<int[]> res = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            for (int j = 0; j<arr[0].length;j++){
                int[] index = new int[2];
                if(arr[i][j]==el){
                    index[0] = i;
                    index[1] = j;
                    res.add(index);
                }
            }
        }
        return res;
    }
}
