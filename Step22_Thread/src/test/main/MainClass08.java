package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		//스레드 시작 시키기
		new Thread(new MyRunnable()).start();
		new Thread(new MyRunnable()).start();
		new Thread(new MyRunnable()).start();
		// 익명 클래스를 활용하면 그때 그때 다른 작업을 수행
		// 할수 있다. 
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("스레드에서 B 작업 수행");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("스레드에서 C 작업 수행");
			}
		}).start();
		
	}
	static class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("새로운 Thread 에서 A 작업수행");
		}
	}
}






