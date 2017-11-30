package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		//1. usePhone() 메소드를 오류없이 호출해 보세요.
		Phone p1=new Phone();
		usePhone(p1);
		//2. useHandPhone() 메소드 호출
		HandPhone p2=new HandPhone();
		useHandPhone(p2);
		//3. useSmartPhone() 메소드 호출
		SmartPhone p3=new SmartPhone();
		useSmartPhone(p3);
	}
	
	public static void usePhone(Phone p) {
		p.call();
	}
	public static void useHandPhone(HandPhone p) {
		p.mobileCall();
	}
	public static void useSmartPhone(SmartPhone p) {
		p.doInternet();
	}
}








