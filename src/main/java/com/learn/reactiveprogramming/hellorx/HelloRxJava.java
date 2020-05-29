package com.learn.reactiveprogramming.hellorx;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

	public static void main(String[] args) {
		Observable<String> source = Observable.create(e -> {
			e.onNext("Hello");
			e.onNext("RxJava");
		});

		source.subscribe(e -> System.out.println("Observer 1 : " + e));
		source.subscribe(e -> System.out.println("Observer 2 : " + e));
		/* output
		 * 
		 * Observer 1 : Hello 
		 * Observer 1 : RxJava 
		 * Observer 2 : Hello 
		 * Observer 2 : RxJava
		 */
	}
}
