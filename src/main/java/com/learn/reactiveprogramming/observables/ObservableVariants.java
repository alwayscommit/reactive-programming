package com.learn.reactiveprogramming.observables;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ObservableVariants {

	public static void main(String[] args) {

		// Single - only one, onNext + onComplete = onSuccess
		Observable<String> source = Observable.just("Aakash", "Ranglani", "Hello World!");

		source.first("Name").subscribe(System.out::println);

		Single.just("Aakash").subscribe(System.out::println);

		// Maybe - may or may not emit a value
		Observable<String> source1 = Observable.empty();
		source1.firstElement().subscribe(System.out::println, e -> e.printStackTrace(),
				() -> System.out.println("Completed!"));
//		source.firstElement().subscribe(System.out::println); -> returns Aakash

		// Completable -> doesn't have onNext, onSuccess method, emits nothing

		Completable completable = Completable.complete();
		completable.subscribe(() -> System.out.println("Completed!"));

		Completable.fromRunnable(() -> System.out.println("Process executing..."))
				.subscribe(() -> System.out.println("process executed successfully!!"));

	}

}
