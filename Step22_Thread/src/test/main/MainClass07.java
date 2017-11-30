package test.main;

public class MainClass07 {
	public static void main(String[] args) {
		//1.
		new MyThread().start();
		
		//2.
		Runnable run=new MyRunnable();
		new Thread(run).start();
	}
	//1.
	static class MyThread extends Thread{
		@Override
		public void run() {
			
		}
	}
	//2.
	static class MyRunnable implements Runnable{
		@Override
		public void run() {
			
		}
	}
}







