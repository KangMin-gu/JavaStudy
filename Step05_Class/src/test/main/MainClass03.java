package test.main;

import test.mypac.Car;
import test.mypac.MyUtil;

public class MainClass03 {
	public static void main(String[] args) {
		//1. MyUtil 클래스의 sendMessage() 메소드를 호출해 보세요.
		MyUtil.sendMessage();
		//2. MyUtil 클래스의 version 이라는 필드에 저장된
		//   문자열을 콘솔에 출력해 보세요.
		System.out.println(MyUtil.version);
		//3. Car Type 객체를 생성해서 drive() 메소드를 호출해 보세요.
		Car car1=new Car();
		car1.drive();
		//4. 위에서 만든 Car Type 객체의 name 필드에 저장된
		//   문자열을 콘솔창에 출력해 보세요.
		System.out.println(car1.name);
	}
}







