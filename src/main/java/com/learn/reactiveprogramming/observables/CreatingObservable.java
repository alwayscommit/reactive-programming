package com.learn.reactiveprogramming.observables;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObservable {

	public static void main(String[] args) {

		//rarely used
		Observable<Integer> source = Observable.create(e -> {
			e.onNext(10);
			e.onNext(11);
			e.onNext(12);
			e.onComplete();
		});

		source.subscribe(System.out::println);
		
		//max 10 items
		Observable<Integer> justSource = Observable.just(1, 2, 3);
		justSource.subscribe(System.out::println);
		
		
		List<String> stringList = List.of("Aakash","Ranglani","Hello","World");
		Observable<String> fromIterable = Observable.fromIterable(stringList);
		fromIterable.subscribe(System.out::println);
	}

}
