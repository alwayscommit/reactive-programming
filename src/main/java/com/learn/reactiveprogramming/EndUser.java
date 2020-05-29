package com.learn.reactiveprogramming;

public class EndUser implements Observer {

	private String name;

	public EndUser(String name, SubjectLibrary subject) {
		this.name = name;
		subject.subscribeObserver(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String avail) {
		System.out.println("Hello, " + name +"! Your book is now " + avail + ".");
	}

}
