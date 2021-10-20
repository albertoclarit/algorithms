package com.albertoclarit.algorithms;

import java.util.Random;
import java.util.concurrent.*;

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

        //newSingleThreadExecutor(ThreadFactory threadFactory)

      //  ExecutorService executor_ = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i=1;i<20;i++){
            executor.submit(()-> {
                try {
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("From Runnable Lambda: " + Thread.currentThread().getName());
            });

        }


        System.out.println("Wait till all is finished");
        executor.shutdown();


        System.out.println("Scheduled");
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();


        for(int i=1;i<20;i++){
            executorService.schedule(()-> {
                System.out.println("From Scheduled Runnable Lambda: " + Thread.currentThread().getName());
            },1, TimeUnit.SECONDS);

        }

        executorService.shutdown();


    }
}
