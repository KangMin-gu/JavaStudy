package test.mypac;

public class AnotherThread extends Thread{
	
	//run() 메소드 재정의
	@Override
	public void run() {
		//새로운 작업단위(스레드)가 시작되는 run() 메소드
		System.out.println("또다른 스레드가 시작 되었습니다.");
		for(int i=0; i<10; i++) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("또다른 스레드가 종료 됩니다.");
	}
}











