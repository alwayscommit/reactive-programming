package com.learn.reactiveprogramming.observables;

import java.util.stream.Stream;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableObserverClass {

	/*
	 * Observable is somewhat similar to iterator iterator pulls from source,
	 * observable pushes data into observer
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {

		// synchronous
		Stream<Integer> streamInt = Stream.of(1, 2, 3);
		streamInt.map(i -> i * 2).forEach(System.out::print);

		System.out.println();

		// capable of being async, lazy by nature, needs to be subscribed to
		Observable<Integer> observable = Observable.create(e -> {
			e.onNext(1);
			e.onNext(2);
			e.onNext(3);
			e.onComplete();

		});
		observable.map(i -> i * 2).subscribe(System.out::print);

		System.out.println();
		System.out.println();



		Observable<Integer> obsInt = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
				try {
					emitter.onNext(10);
					emitter.onNext(12);
					emitter.onComplete();
				} catch (Throwable t) {
					emitter.onError(t);
				}

			}

		});

		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("Subscribed...");
			}

			@Override
			public void onNext(@NonNull Integer t) {
				System.out.println("On Next :: " + t);
			}

			@Override
			public void onError(@NonNull Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed!");
			}
			
		};
		
		obsInt.subscribe(observer);
	}

}
