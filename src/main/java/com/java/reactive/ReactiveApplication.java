package com.java.reactive;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.java.reactive.file.FileUtil;
import com.java.reactive.util.Util;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ReactiveApplication.class, args);
		
		
//		Mono<String> user = Mono.just("Dara");
//		Mono<Integer> user = Mono.just(1)
//				.map(x-> x/0)
//				.map(x->5);
//		user.subscribe(u->System.out.println(u));
		
//		user.subscribe(
//				 Util.onNext(), 
//				 Util.onError(), 
//				 Util.onComplete());		
//		for(int i=1; i<100; i++) {
//			String name = Faker.instance().country().capital();
//			System.out.println(name);
//		}
		
		
//				new CountryRepository()
//				.findById(0)
//				.subscribe(
//				 Util.onNext(), 
//				 Util.onError(), 
//				 Util.onComplete()
//				);
		
// From Supplier
//		printer();
//		printer()
//		//Execute parallel
//		.subscribeOn(Schedulers.boundedElastic())
//		.subscribe(Util.onNext());
//		printer();
//		
//		//Block
//		Util.deplay(5);


		// Write Data
		FileUtil.fileWriter("FileData.txt", "This is Java Reactive.")
		        .subscribe(
				 Util.onNext(), 
				 Util.onError(), 
				 Util.onComplete());
		
		// Read Data
		FileUtil.FileReader("FileData.txt")
		        .subscribe(
				 Util.onNext(), 
				 Util.onError(), 
				 Util.onComplete());	
		
		
		// Delete File
//		FileUtil.deleteFile("FileData.txt")
//		.subscribe(
//				Util.onNext(), 
//				Util.onError(), 
//				Util.onComplete());	
//		
	}
	
	public static Mono<String> printer() {
		System.out.println("Printer");
		return Mono.fromSupplier(()->{
			System.out.println("Printing");
//			Util.deplay(5);
			return Faker.instance().country().name();
		});
	}

}
