package com.albertoclarit.algorithms;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrent {

    public static void main(String args[]){

        Thread newThread = new Thread(()-> System.out.println("From Runnable Lambda: " + Thread.currentThread().getName() ));
        newThread.start();

        Thread newThread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("From Run method:" + Thread.currentThread().getName());
            }
        });

        newThread2.start();



        //=================================

        //newSingleThreadExecutor(ThreadFactory threadFactory) t
        ExecutorService executor = Executors.newFixedThreadPool(10);
        new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        }
        for(int i=1;i<100;i++){
            executor.submit(()-> {
                try {
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("From Runnable Lambda: " + Thread.currentThread().getName());
            });

        }


        System.out.println("Exit");
        executor.shutdown();
    }
}
