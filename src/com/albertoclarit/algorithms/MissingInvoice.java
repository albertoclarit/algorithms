package com.albertoclarit.algorithms;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissingInvoice {

    public static void main(String []args) throws FileNotFoundException {


        FileReader fileReader = new FileReader("/Users/albertoclarit/Documents/code_study/java/Algorithms/src/naga");


         int start = 1276;
         int end = 357;

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> lines = bufferedReader.lines().collect(Collectors.toList());

        List<String> range = lines.stream().filter(x-> x.contains("-")).collect(Collectors.toList());
        List<String> invoice = new ArrayList<>(lines.stream().filter(x-> !x.contains("-")).collect(Collectors.toList()));

        range.forEach(x->{

            String []r = x.split("\\-");

            Integer f = Integer.valueOf(r[0]);
            Integer t = Integer.valueOf(r[1]);
            for(int i=f;i<=t;i++)
                invoice.add(i+"");

        });




        for(int i=end;i<=start;i++){
            if(!invoice.contains(StringUtils.leftPad(i+"",4,"0"))){
                System.out.println("" + i);
            }

        }







    }
}
