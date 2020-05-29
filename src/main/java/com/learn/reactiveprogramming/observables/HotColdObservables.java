package com.learn.reactiveprogramming.observables;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class HotColdObservables {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Observable<Integer> source = Observable.fromIterable(list);
		
		source.subscribe(System.out::println);
		
		//cold observable
		list = getData(list);
		System.out.println("Modified data...");
		source.subscribe(System.out::println);
		
	}
	
	private static List<Integer> getData(List<Integer> list){
		list.add(4);
		return list;
	}

}
