package com.java.reactive.util;

import com.github.javafaker.Faker;

import reactor.core.publisher.Mono;

public class CountryRepository {
	
	public static Mono<String> findById(int id){
		if(id == 1) {
			return Mono.just(Faker.instance().country().name());
		}else if (id > 1) {
			return Mono.empty();
		}
		return Mono.error(new RuntimeException("Mono can't give more than 1 item!"));
	}

}
