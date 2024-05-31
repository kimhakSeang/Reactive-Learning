package com.java.reactive.file.publisher.hotcold;

import java.time.Duration;
import java.util.stream.Stream;

import com.java.reactive.util.Util;

import reactor.core.publisher.Flux;

public class HCpublisher {
	public static void main(String[] args) {

//		getEpMovie().forEach(ep -> System.out.println("The total ep: "+ ep));
//		System.out.println("You are watching ");
//
		Flux<String> flux = Flux
		    .fromStream(()->getEpMovie())
//		    .share()
		    .publish()
		    .refCount(3)
		    .delayElements(Duration.ofSeconds(2));
		
		flux.subscribe(Util.subcriber("First"));
		
		Util.deplay(5);

		
		flux.subscribe(Util.subcriber("Second"));;
		
		Util.deplay(15);
	}
	private static Stream<String> getEpMovie(){
		return Stream.of("Ep 1", "Ep 2", "Ep 3", "Ep 4", "EP 5");
	}
}
