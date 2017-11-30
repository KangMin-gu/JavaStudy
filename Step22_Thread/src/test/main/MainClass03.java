package test.main;

public class MainClass03 {
	
	public static void main(String[] args) {
		//새로운 스레드 시작 시키기 
		new YourThread().start();
		new YourThread().start();
		new YourThread().start();
	}
	
	static class YourThread extends Thread{
		@Override
		public void run() {
			System.out.println("새로운 스레드");	
		}
	}
}
