package com.company;

import java.util.List;

public class MulltipleThreadTimeMove {
    public static void timeMove(List<int[]>crystal, long timeMs){
        SingleThreadTimeMove[] threadArray = new SingleThreadTimeMove[crystal.get(0).length];
        for(int i = 0; i<threadArray.length;i++){
            threadArray[i] = new SingleThreadTimeMove(timeMs,i,crystal);
        }
        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].getThr().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
