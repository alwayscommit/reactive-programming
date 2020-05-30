package com.learn.reactiveprogramming.operators;

import io.reactivex.rxjava3.core.Observable;

public class Operators {
	
	public static void main(String[] args) {
		
		Observable.just(20, 30, 40, 50, 35).filter(e -> e > 30).sorted().subscribe(e -> System.out.println("You are old! " + e));
		
		/*
		 * - Suppressing Operators
		 * 
		 * suppresses the emissions which fail to meet some specific criteria
		 * example: filter
		 * 
		 * 
		 * - Transforming Operators
		 * 
		 * transforms the emissions
		 * type of returned observable may or may not be the same
		 * 
		 * 
		 * - Reducing Operators
		 * 
		 * takes a series of emission and reduces them to a single emission
		 * works with finite observables
		 * 
		 * 
		 * - Collection operators
		 * 
		 * another type of reducing operators as they combine emissions from upstream to some collection
		 * reduces emissions to a single collection
		 * 
		 * 
		 * - Error Recovery Operators
		 * 
		 * used to handle the errors and to recover from them
		 * 
		 */
		
	}

}
