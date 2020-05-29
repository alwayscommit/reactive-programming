package com.learn.reactiveprogramming;

public interface AnotherCallback {
	
	void pushData(String data);
	
	void pushComplete();
	
	void pushException(Exception ex);

}
