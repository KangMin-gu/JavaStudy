package test.mypac;
/*
 *  [ 메소드 정의하기 ]
 *  
 *  1. 접근지정자 ?
 *  2. static or non static ?
 *  3. return 데이터 type ?
 *  4. 메소드명 ?
 *  5. 메소드에 전달받는 인자의 갯수와 데이터 type ? 
 */
public class MyUtil {
	
	//메소드 정의하기 
	public static void showVersion() {
		System.out.println("showVersion() 호출됨!");
	}
	
	public void sendMessage() {
		System.out.println("sendMessage() 호출됨!");
	}
	
	public static int getNum() {
		System.out.println("getNum() 호출됨!");
		return 10;
	}
	
	public static String getMessage() {
		System.out.println("getMessage() 호출됨");
		return "Hello! mama!";
	}
	
	public String getName() {
		System.out.println("getName() 호출됨");
		return "김구라";
	}
	
	/*
	 *  접근 지정자 : public
	 *  static
	 *  리턴 데이터 type : Car
	 *  메소드명 : getCar
	 *  메소드 인자 : 없음
	 */
	public static Car getCar() {
		// Car 객체를 생성해서 참조값을 변수에 담은 다음
		Car car=new Car();
		// 변수에 저장된 참조값을 리턴해 준다. 
		return car;
	}
	// 인자로 String type 을 받는 메소드 
	public static void printMsg(String msg) {
		System.out.println("printMsg() 호출됨");
	}
}























