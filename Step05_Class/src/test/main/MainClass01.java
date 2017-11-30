package test.main;

import test.mypac.Car;
import test.mypac.Gura;

/*
 *  [ 클래스의 역활 ]
 *  
 *  1. static 맴버를 가지고 있는 역활
 *  2. 객체의 설계도 역활
 *  3. Data Type 역활
 */
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		// Car Type 객체의 참조값을 담을 지역변수 만들기 
		Car car1=null;
		// Car 객체를 생성하고 참조값을 변수에 대입하기 
		car1=new Car();
		
		// Gura Type 객체의 참조값을 담을 지역변수 만들기 
		Gura gura1=null;
		// Gura 객체를 생성하고 참조값을 변수에 대입하기 
		gura1=new Gura();
		
		//객체의 필드 참조 
		String a = car1.name;
		//객체의 메소드 호출
		car1.drive();
	}
}












