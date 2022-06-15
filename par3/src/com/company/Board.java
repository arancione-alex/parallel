package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Board {
    MyDrawPanel drawPanel;
    int boardSize;
    double probability;
    int bitsAmount;
    int iterationsAmount;
    int secondsExecution;
    List<Dot> board = new ArrayList<>();

    public Board(int boardSize, double probability, int iterationsAmount, int bitsAmount) {
        this.boardSize = boardSize * 10;
        this.probability = probability;
        this.iterationsAmount = iterationsAmount;
        this.bitsAmount = bitsAmount;
    }

    public Board(int boardSize, double probability, Date date, int bitsAmount) {
        this.boardSize = boardSize * 10;
        this.probability = probability;
        this.iterationsAmount = iterationsAmount;
        this.bitsAmount = bitsAmount;
        this.secondsExecution = date.getSeconds();
    }

    public void calculate() {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setSize(boardSize, boardSize);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        for (int i = 0; i < bitsAmount; i++) {
            board.add(new Dot(0, 400));
        }
        board.forEach(dot -> new Thread(() -> moveBallWithIterations(dot)).start());
        board.forEach(dot -> new Thread(() -> moveBallWithTimeLimit(dot, secondsExecution)).start());
    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            board.stream().forEach(dot -> g.fillOval(dot.getX(), dot.getY(), 10, 10));
        }
    }

    private void moveBallWithTimeLimit(Dot dot, int seconds) {

        boolean moveBallRight = true;
        int x = dot.getX();
        long startTime = System.currentTimeMillis() / 1000;
        long endTime = startTime + seconds;
        while (System.currentTimeMillis() / 1000 < endTime) {
            if (Math.random() <= probability && moveBallRight) {
                if (x < boardSize) {
                    x++;
                } else {
                    moveBallRight = false;
                }
            } else {
                if (x > 0) {
                    x--;
                } else {
                    moveBallRight = true;
                }
            }


            dot.setX(x);
            drawPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (Exception exc) {
            }
        }
    }

    private void moveBallWithIterations(Dot dot) {
        boolean moveBallRight = true;
        int x = dot.getX();

        for (int i = 0; i < iterationsAmount; i++) {
            if (Math.random() <= probability && moveBallRight) {
                if (x < boardSize) {
                    x++;
                } else {
                    moveBallRight = false;
                }
            } else {
                if (x > 0) {
                    x--;
                } else {
                    moveBallRight = true;
                }
            }

            dot.setX(x);
            drawPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (Exception exc) {
            }
        }
    }
}
