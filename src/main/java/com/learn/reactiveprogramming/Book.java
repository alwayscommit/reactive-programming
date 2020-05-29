package com.learn.reactiveprogramming;

import java.util.ArrayList;

public class Book implements SubjectLibrary {

	private String name;
	private String type;
	private String author;
	private double price;
	private String inStock;
	private ArrayList<Observer> obList;

	public Book(String name, String type, String author, double price, String inStock) {
		this.name = name;
		this.type = type;
		this.author = author;
		this.price = price;
		this.inStock = inStock;
		obList = new ArrayList<Observer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
		System.out.println("Availability changed from Sold out to In Stock!");
		notifyObserver();
	}

	public ArrayList<Observer> getObList() {
		return obList;
	}

	public void setObList(ArrayList<Observer> obList) {
		this.obList = obList;
	}

	@Override
	public void subscribeObserver(Observer ob) {
		obList.add(ob);
	}

	@Override
	public void unsubscribeObserver(Observer ob) {
		obList.remove(ob);
	}

	@Override
	public void notifyObserver() {
		System.out.println("Book [name=" + name + ", type=" + type + ", author=" + author + ", price=" + price
				+ ", inStock=" + inStock + "]");
		
		for (Observer o : obList) {
			o.update(this.inStock);
		}
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", type=" + type + ", author=" + author + ", price=" + price + ", inStock="
				+ inStock + "]";
	}

}
