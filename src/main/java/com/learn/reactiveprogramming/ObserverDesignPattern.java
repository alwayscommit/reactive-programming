package com.learn.reactiveprogramming;

public class ObserverDesignPattern {

	//Reactive APIs follow this pattern.
	
	public static void main(String[] args) {
		
		Book book = new Book("Alladin", "Random", "ABC", 200, "Sold out");
		
		EndUser user1 = new EndUser("Bob", book);
		EndUser user2 = new EndUser("Tom", book);
		
		System.out.println(book.getInStock());
		
		
		book.setInStock("In stock");
	}
	

}
 