package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
/*
 *  [ extends 상속 ]
 *  
 *  1. 클래스를 상속 받는 문법 학습
 *  2. 상속받은 클래스를 이용해서 객체 생성했을때 참조값을 
 *     받아 줄수 있는 다양한 type 학습
 *  3. 형변환(casting) 연산자의 활용
 *  4. 자식 생성자에서 부모 생성자에 값을 전달하는 방법
 *  5. 메소드 오버라이딩(재정의) 하는 방법
 *  6. 오버라이딩 한 메소드에서 부모객체의 메소드를 호출하는 방법
 */
public class MainClass01 {
	public static void main(String[] args) {
		Phone p1=new Phone();
		p1.call();
		System.out.println("--------");
		
		HandPhone p2=new HandPhone();
		p2.call();
		p2.mobileCall();
		p2.takePicture();
	}
}






