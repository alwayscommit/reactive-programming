package com.learn.reactiveprogramming;

public class CallbackDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Main thread is running...");

		Runnable r = new Runnable() {

			@Override
			public void run() {
				new CallbackDemo().runningAsync(new Callback() {
					
					@Override
					public void call() {
						System.out.println("Callback called!");
					}
				});
			}
			
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		Thread.sleep(2000);
		
		System.out.println("main thread completed!");
	}

	public void runningAsync(Callback callback) {
		System.out.println("Running a separate thread...");
		sleep(1000);
		callback.call();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
