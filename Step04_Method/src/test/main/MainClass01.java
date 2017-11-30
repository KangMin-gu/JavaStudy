package test.main;

public class MainClass01 {
	
	// 실행 순서가 시작되는 main 메소드
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작됨");
		
		// static member method gura() 호출하기
		/*
		 *  static 메소드는 class 명으로 접근한다. 
		 */
		MainClass01.gura();
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
	
	//static member method 추가 
	public static void gura() {
		System.out.println("gura 메소드가 시작됨");
		
		System.out.println("gura 메소드가 종료 됩니다.");
	}
}




