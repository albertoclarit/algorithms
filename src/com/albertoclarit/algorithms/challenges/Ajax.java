package com.albertoclarit.algorithms.challenges;

public class Ajax {

    public static void main(String []args){

        String input = "aaabbcddfgghh";


        String output = compress(input);

        System.out.println(output);

    }

    public static String compress(String input){

        StringBuilder stringBuilder = new StringBuilder();

        char last = input.charAt(0);
        int count = 1;

        for(int i=1; i<input.length();i++){
            if(last == input.charAt(i))
                count++;
            else {

                if(count > 1)
                    stringBuilder.append(count+""+ last);
                else
                    stringBuilder.append(last);

                    count=1;
            }

            last = input.charAt(i);

        }

        if(count > 1)
            stringBuilder.append(count+""+ last);
        else
            stringBuilder.append(last);


        return stringBuilder.toString();
    }




}
