package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        double probability = 0.7;
        int iterationsAmount = 500;
        int bitsAmount = 10;
        Board boardWithIterations = new Board(40, probability, iterationsAmount, bitsAmount);
        Date date = new Date();
        date.setSeconds(100);
        Board boardWithTimeOut = new Board(40, probability, date, bitsAmount);
        boardWithTimeOut.calculate();
        boardWithIterations.calculate();
    }
}
