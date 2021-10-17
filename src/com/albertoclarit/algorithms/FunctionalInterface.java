package com.albertoclarit.algorithms;



import java.util.function.Consumer;
import java.util.function.Supplier;


interface  MyFunction<T,R>{
    R call(T r);
}

public class FunctionalInterface {

    public static void main(String args[]){

        useFunctional(100, Object::toString);
        useConsumer("Albert", System.out::println);
        useSupplier(()->  "Supplier");
    }
    public static  void useFunctional(int value, MyFunction<Integer,String> function){
       String result  =  function.call(value);
       System.out.println("Result is: " + result);
    }


    public static  void useConsumer(String value, Consumer<String> consumer){
        consumer.accept(value);
    }

    public static  void useSupplier( Supplier<String> supplier){
         System.out.println("Supplier:" + supplier.get());
    }
}

