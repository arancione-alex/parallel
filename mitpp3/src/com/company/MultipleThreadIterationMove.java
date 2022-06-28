package com.company;

import java.util.List;

public class MultipleThreadIterationMove {
    static void iterationMove(List<int[]> crystal, int iterations){
        SingleThreadIterationMove[] threadArray = new SingleThreadIterationMove[crystal.get(0).length];
        for(int i = 0;i<threadArray.length;i++){
            threadArray[i]=new SingleThreadIterationMove(iterations,i,crystal);
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
