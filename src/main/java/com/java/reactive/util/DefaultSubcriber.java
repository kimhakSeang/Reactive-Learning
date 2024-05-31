package com.java.reactive.util;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubcriber  implements Subscriber<Object>{
	String name = "";
	public DefaultSubcriber(String name) {
		this.name = name;
	}

	@Override
	public void onNext(Object item) {
		System.out.println(name +" On Next: "+ item);
		
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println(name +" On Error: "+throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println(name +" On Completed.");
		
	}

	@Override
	public void onSubscribe(Subscription s) {
		s.request(Long.MAX_VALUE);
		
	}
	
}
