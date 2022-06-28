package com.company;

import java.util.List;
import java.util.Random;

public class SingleThreadIterationMove implements Runnable{
    private int iterations;
    private int particle;
    List<int[]> crystal;
    private Thread thr;

    public SingleThreadIterationMove(int iterations, int particle, List<int[]> crystal) {
        this.iterations = iterations;
        this.particle = particle;
        this.crystal = crystal;
        thr = new Thread(this);
        thr.start();
    }
    public Thread getThr() {
        return thr;
    }

    @Override
    public void run() {
        Random rn = new Random();
        for(int i =0;i<iterations;i++){
            for(int j =0;j<crystal.size();j++){
                if(crystal.get(j)[particle]==1){
                    if(j==0){
                        crystal.get(j)[particle]=0;
                        crystal.get(j+1)[particle]=1;
                    }
                    else if(j==crystal.size()-1){
                        crystal.get(j)[particle]=0;
                        crystal.get(j-1)[particle]=1;
                    }
                    else{
                        double p = rn.nextDouble(1);
                        if(p<0.5){
                            crystal.get(j)[particle]=0;
                            crystal.get(j-1)[particle]=1;
                        }
                        else if(p>0.5){
                            crystal.get(j)[particle]=0;
                            crystal.get(j+1)[particle]=1;
                        }
                    }
                }
            }
        }
    }
}
