package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiThreadMultiply {
    static void mul(int[][][] matrixes, int threads){
        SingleThreadMultiply[] threadArray = new SingleThreadMultiply[threads];
        for (int i = 0; i < threadArray.length; i++) {
            int size = matrixes.length / threads;
            int begin = size * i;
            int end = ((i + 1) * size);
            if ((matrixes.length - end) < size) {
                end = matrixes.length;
            }
            threadArray[i] = new SingleThreadMultiply(matrixes, begin, end);
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
