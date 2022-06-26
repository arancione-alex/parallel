package com.company;

import java.util.*;
import java.util.stream.Collectors;



import static java.lang.Integer.MAX_VALUE;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int minThreads = 1;
        int maxThreads = 8;
        int limit;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first matrix height:");
        int a1 = sc.nextInt();
        System.out.println("Enter first matrix width:");
        int a2 =sc.nextInt();
        System.out.println("Enter second matrix height:");
        int b1 = sc.nextInt();
        System.out.println("Enter second matrix width:");
        int b2 = sc.nextInt();
        int[][] a = MatrixWork.generateMatrix(a1,a2);
        int[][] b = MatrixWork.generateMatrix(b1,b2);
        int[][] c = MatrixWork.multiplyMatrixes(a,b);
        for(int i = 0; i<c.length;i++){
            System.out.println(Arrays.toString(c[i]));
        }
        List<int[]> list =new ArrayList<>(Arrays.asList(c));
        List<List<Integer>> min = new ArrayList<>();
        for(int threads = minThreads;threads <= maxThreads;threads++){
            List<Integer> minPart =new ArrayList<>();
            limit = list.size()/threads;
            List<List<int[]>> splitList = splitList(limit,list);
            long start = System.currentTimeMillis();
            splitList.forEach(list1 -> new Thread(() -> minPart.add(findMin(list1))).start());
            long end =System.currentTimeMillis();
            min.add(minPart);
            sleep(10);

        }

        System.out.println(min);
        System.out.println(min.get(0).get(0));
        List<int[]> indexes = MatrixWork.findElement(c, min.get(0).get(0));
        for(int z = 0; z<indexes.size();z++)
        System.out.println(Arrays.toString(indexes.get(z)));
    }
    public static int findMin(List<int[]> list){
        int res = MAX_VALUE;
        for(int i = 0; i<list.size();i++){
            for (int j = 0;j<list.get(i).length;j++){
                if(list.get(i)[j]<res){
                    res=list.get(i)[j];

                }
            }
        }
        return res;
    }
    public static List<List<int[]>> splitList(int limit, List<int[]> matrixes) {
        List<List<int[]>> splitedList = new ArrayList<>();
        int steps = matrixes.size() / limit;
        for (int i = 0; i < steps; i++) {
            splitedList.add(matrixes.stream()
                    .skip((long) limit * i)
                    .limit(limit)
                    .collect(Collectors.toList()));
        }
        return splitedList;
    }



}
