package com.learn.reactiveprogramming.observables;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class DisposeClass {

	private static final CompositeDisposable DISPOSER = new CompositeDisposable();

	public static void main(String[] args) throws InterruptedException {

		@NonNull
		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

		Disposable d1 = source.subscribe(e -> System.out.println("Observer 1 :: " + e));

//		d1.dispose();

		Disposable d2 = source.subscribe(e -> System.out.println("Observer 2 :: " + e));

		Thread.sleep(5000);

		DISPOSER.addAll(d1, d2);
		DISPOSER.dispose();

		Thread.sleep(10000);

	}

}
