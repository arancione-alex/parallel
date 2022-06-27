package com.company;

import java.io.*;
import java.util.List;
import java.util.Random;

public class SingleThreadIO implements Runnable{
    static int filesize = 129 * 1024;
    byte[] bytes = new byte[filesize];
    private List<String> list;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    public SingleThreadIO(List<String> list, int begin, int end) {
        this.list = list;
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
        for (String fileName : list) {
            File file = new File(fileName);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert fileOutputStream != null;
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            Random rand = new Random();
            rand.nextBytes(bytes);
            try {
                bufferedOutputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
