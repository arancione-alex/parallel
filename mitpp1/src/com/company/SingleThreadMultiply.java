package com.company;

import java.util.List;

public class SingleThreadMultiply implements Runnable{
    private int[][][] matrixes;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    public SingleThreadMultiply(int[][][] matrixes, int begin, int end) {
        this.matrixes = matrixes;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
        this.index=begin;
    }
    public Thread getThr() {
        return thr;
    }


    @Override
    public void run() {
        for(int z = 0; z<matrixes.length-1;z++){
            int m = matrixes[z].length;
            int n = matrixes[z+1][0].length;
            int o = matrixes[z+1].length;
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < o; k++) {
                        res[i][j] += matrixes[z][i][k] * matrixes[z+1][k][j];
                    }
                }
            }
        }
    }
}
