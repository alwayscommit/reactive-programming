package com.learn.reactiveprogramming;

public class AnotherCallbackDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Main thread is running...");

		Runnable r = new Runnable() {

			@Override
			public void run() {
				new AnotherCallbackDemo().runningAsync(new AnotherCallback() {

					@Override
					public void pushData(String data) {
						System.out.println("Callback data : " + data);
					}

					@Override
					public void pushComplete() {
						System.out.println("Callback done!");
					}

					@Override
					public void pushException(Exception ex) {
						System.out.println("Callback error called, got an exception ::" + ex);
					}

				});
			}

		};

		Thread t1 = new Thread(r);
		t1.start();
		Thread.sleep(2000);

		System.out.println("main thread completed!");
	}

	public void runningAsync(AnotherCallback callback) {
		System.out.println("Running a separate thread...");
		sleep(1000);
		callback.pushData("Data1");
		callback.pushData("Data2");
		callback.pushData("Data3");

		// if there's an exception, pushComplete is not called.
		callback.pushException(new RuntimeException("Oops!"));

		// This is called after exception only for demo purposes
		callback.pushComplete();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
