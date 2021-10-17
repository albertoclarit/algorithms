package com.albertoclarit.algorithms;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Reactor {

    public static  void  main(String []args){


        List<Integer> elements = new ArrayList<>();
        Flux<Integer> just = Flux.just(1, 2, 3, 4);

                just.log()
                .subscribe(elements::add); //returns disposable

                 // cannot
                 just.subscribe(it-> System.out.println("Value is " + it));


                 // Using subscriber

        System.out.println("=====Subscriber ====== ");
        Flux.just(11, 12, 13, 14)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Subscriber It: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        System.out.println("=====Subscriber with BackPressure ====== ");
        Flux.just(21, 22, 23, 24)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int onNextAmount;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.s = subscription;
                        subscription.request(2);

                    }

                    @Override
                    public void onNext(Integer integer) {
                        onNextAmount++;
                        if (onNextAmount % 2 == 0) {
                            s.request(2);
                        }

                        System.out.println("Subscriber It: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }
}
