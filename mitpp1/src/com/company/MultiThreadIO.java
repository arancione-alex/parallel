package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiThreadIO {
    static void execute(int threads, String dir){
        SingleThreadIO[] threadArray = new SingleThreadIO[threads];
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            fileNames.add(dir +"input"+ i + ".txt");
        }
        for (int i = 0; i < threadArray.length; i++) {
            int size = fileNames.size() / threads;
            int begin = size * i;
            int end = ((i + 1) * size);
            if ((fileNames.size() - end) < size) {
                end = fileNames.size();
            }
            threadArray[i] = new SingleThreadIO(fileNames, begin, end);
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
