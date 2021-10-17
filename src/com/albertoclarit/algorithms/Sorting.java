package com.albertoclarit.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public static void main(String []args){

        int []data = new int[20];



        randomizer(data);
        System.out.println("Original Array");
        Arrays.stream(data).forEach(i -> {
            System.out.print(i+ " ");
        } );
        bubbleSort(data);

        System.out.println("\nBubble Sort");
        Arrays.stream(data).forEach(i -> {
            System.out.print(i+ " ");
        } );

        randomizer(data);
        System.out.println("\nOriginal Array");
        Arrays.stream(data).forEach(i -> {
            System.out.print(i+ " ");
        } );

        selectionSort(data);

        System.out.println("\nSelection Sort");
        Arrays.stream(data).forEach(i -> {
            System.out.print(i+ " ");
        } );



    }


    public  static void  randomizer(int []data){

        for(int i=0;i<data.length;i++){
            data[i] = new Random().nextInt(1000);
        }
    }

    public  static  void swap(int data[],int a, int b){
         int temp = data[a];
         data[a] = data[b];
         data[b] = temp;
    }

    public static void bubbleSort(int []data){
        long started = System.nanoTime();
        for(int outer=data.length -1; outer > 0; outer-- ){
            for(int inner = 0; inner < outer; inner ++){
                if(data[inner] > data[inner +1])
                    swap(data,inner,inner + 1 );
            }
        }

        System.out.println("\n--- Time elapsed in MS:" + (System.nanoTime() - started) + "----");
    }

    // index based
    public static void selectionSort(int []data){
        long started = System.nanoTime();
        for(int outer=0; outer < data.length -1; outer++ ){
            int smallest = outer;
            for(int inner = outer+1; inner < data.length ; inner ++){
                 if( data[inner] < data[smallest])
                     smallest  = inner;
            }
            if(smallest != outer){
                swap(data,outer,smallest);
            }
        }
        System.out.println("\n--- Time elapsed in MS:" + (System.nanoTime() - started) + "----");
    }

    // two parts  sorted marker unsorted
    public static void insertionSort(int []data){

    }





}
