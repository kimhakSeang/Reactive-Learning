package com.java.reactive;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.java.reactive.util.Util;

import reactor.core.publisher.Flux;

public class Flux_Homework_3 {
	public static void main(String[] args) {

		Random random = new Random();
		AtomicInteger num = new AtomicInteger(95);
		int[] count = {1};
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));// Delay 2 second
		interval.subscribe(x -> {
			                
			                //True is increase, other hand is decrease
		                    if (random.nextBoolean()) {
		                        num.addAndGet(4);
		                    } else {
		                        num.addAndGet(-4);
		                    }
		                    
		                    System.out.println("Number " + count[0] + " = " + num.get());
		                    count[0]++;
		                    
		                    //Must between 90 to 105
		                    if (num.get() < 90 || num.get() > 105) {
		                        throw new RuntimeException("Value is not under control[93->105] !");
		                    }
		                }
		        , Util.onError()
		        , Util.onComplete()
		        );
			    
	       Util.deplay(2000);
	}
}






