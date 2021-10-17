package com.albertoclarit.algorithms;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {


    public static void main(String []args){

        // Stream can be from
        // list.stream(),
        // collection.stream()
        // Stream.of("a", "b", "c");
        // Arrays.stream([]);
        Stream<Integer> streamGenerated =
                Stream.generate(() -> new Random().nextInt(10000)).limit(20);

        // Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        // like a loop starting from 40 for 20 items

        streamGenerated // source
                .filter( x-> x % 2 == 0 ) // intermediate operation
                .forEach(System.out::println); // terminal operation - terminate

        streamGenerated =
               Stream.generate(() -> new Random().nextInt(10000)).limit(20);

        System.out.println("First : " + streamGenerated.findFirst().orElse(23));

        streamGenerated =
                Stream.generate(() -> new Random().nextInt(10000)).limit(20);


        // map returns a stream
        streamGenerated.map( x-> "X:" + x).forEach(System.out::println);

        streamGenerated =
                Stream.generate(() -> new Random().nextInt(10000)).limit(20);

        System.out.println("======");
        List<String> collect = streamGenerated
                .peek(x-> System.out.println("Peek:" + x)) // intermediate operation
                .map(x -> "X:" + x)// intermediate operation
                .collect(Collectors.toList()); // terminator

        collect.forEach(System.out::println);

        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b); // terminator

        System.out.println("Reduce 1 " + reduced.orElse(-1));


    }
}
