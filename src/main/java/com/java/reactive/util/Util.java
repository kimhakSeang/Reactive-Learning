package com.java.reactive.util;

import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.Random;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import reactor.core.publisher.Flux;

public class Util {
	
	public static Consumer<String> startFlux(int doration, int delay){
		Random random = new Random();
        int initValue = 95;
        
		Flux<Long> interval = Flux.interval(ofSeconds(2));
		interval.map(i-> i + 1)
//		.takeUntil(value -> value == 92)
        .subscribe(x->{
	            if(x > 95 || x > 105) {
	            	throw new RuntimeException("Terminating the flux");
	            }
	        	System.out.println(" -> "+(initValue+(random.nextInt(9) - 4)));
	        }
        );
		
		Flux<Long> closeIntervalFlux = Flux.interval(Duration.ofSeconds(2)).doOnNext(value -> {
		    if (value == 5) {
		        throw new RuntimeException("Terminating the flux");
		    }
		});
		return null;	
	}
	
	public static DefaultSubcriber subcriber(String name	) {
		return new DefaultSubcriber(name);
	}
	
	public static Consumer<String> onNext(){
		return x->System.out.println("onNext: "+x);
	}
	
	public static Consumer<Throwable> onError(){
		return x-> System.out.println("onError: "+x.getMessage());
	}
	public static Runnable onComplete() {
		return () -> System.out.println("onComplete: Done");
	}
//    public static Throwable monoException() {
//    	return 
//    }
	
	public static void deplay(int secend) {
		try {
			Thread.sleep(secend * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
