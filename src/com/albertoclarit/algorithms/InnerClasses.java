package com.albertoclarit.algorithms;


//https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
public class InnerClasses {

    String data = "Instance Value";

    static String staticData = "Static Value";
     class InnerClass{

         InnerClass(){
             System.out.println(data);
         }
     }


    static  class StaticInnerClass{

         StaticInnerClass(){
             System.out.println(staticData);
         }
    }


    public static void main(String args[]){

         InnerClasses innerClasses = new InnerClasses();
         InnerClass innerClass =   innerClasses.new InnerClass();
         InnerClasses.StaticInnerClass staticInnerClass = new  InnerClasses.StaticInnerClass();




    }

}
