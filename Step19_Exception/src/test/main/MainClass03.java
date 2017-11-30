package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		try {
			//스레드(작업단위, 실행순서) 5초 동안 멈추기 
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			//InterrupedException 은 RuntimeException 을 
			//상속받지 않았기 때문에 반드시 try~catch 블럭으로
			//예외 처리를 해야 문법적으로 성립된다. 
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
