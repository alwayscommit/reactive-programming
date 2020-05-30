package com.learn.reactiveprogramming.operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {

	public static void main(String[] args) {

		Observable<Employee> employeeObs = Observable.just(new Employee(10, "Aakash", 90000, 5),
				new Employee(11, "Aakash1", 91000, 0), new Employee(12, "Aakash2", 92000, 4),
				new Employee(13, "Aakash3", 93000, 3), new Employee(14, "Aakash4", 94000, 2),
				new Employee(15, "Aakash5", 95000, 1), new Employee(16, "Aakash6", 96000, 5),
				new Employee(17, "Aakash7", 97000, 4), new Employee(18, "Aakash8", 98000, 3),
				new Employee(19, "Aakash9", 99000, 2));

		employeeObs.filter(e -> e.getRating() > 3.5).sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
				.map(e -> e.getName()).take(4).subscribe(System.out::println);

		List<Integer> expenses = List.of(200, 300, 400, 500, 100, 250, 340, 140, 900, 870);

		//only prints the total
		Observable.fromIterable(expenses).reduce((a, b) -> a + b).subscribe(System.out::println);
		
		Observable.fromIterable(expenses).scan((a, b) -> a + b).subscribe(System.out::println);
		//prints a+b, a+b+c, a+b+c+d
	}
}
