package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass02 {
	public static void main(String[] args) {
		// SmartPhone 객체의 참조값을 다양한 type 변수에 
		// 담을수 있다 (다형성)
		Object p1=new SmartPhone();
		Phone p2=new SmartPhone();
		HandPhone p3=new SmartPhone();
		SmartPhone p4=new SmartPhone();
	
	}
}












