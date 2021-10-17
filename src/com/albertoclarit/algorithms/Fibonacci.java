package com.albertoclarit.algorithms;

public class Fibonacci {

    public static void main(String args[]){

        System.out.println("Fibonacci Array: " + fiboArray(12));
        System.out.println("Fibonacci Recursive: " + fiboRecursive(12));
    }


    // 0 1 1 2 3 5 8 13 21 34 55 89 144
    public static int fiboArray(int position){
        if(position == 0 || position == 1)
            return position;


        int firstTerm = 0;
        int secondTerm = 1;

         for(int i=1; i <position; ++i){
             int nextTerm = firstTerm + secondTerm;
             firstTerm = secondTerm;
             secondTerm = nextTerm;
         }

       return secondTerm;
    }

    public static int fiboRecursive(int position){
        if(position == 0 || position == 1)
            return position;
        return fiboRecursive(position - 1) + fiboRecursive(position  -2);
    }
}
