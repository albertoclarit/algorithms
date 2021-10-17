package com.albertoclarit.algorithms;


public class Factorial {
    public  static void main(String []args){
        System.out.println("Factorial : " + factorial(5));
    }
    // f(5)= 5*4*3*2*1
    public static int factorial(int n){
        if(n == 0)
            return 1;
        return  n * factorial(n -1);
    }
}
