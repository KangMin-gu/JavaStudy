package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass06 {
	public static void main(String[] args) {
		
		SmartPhone p1=new SmartPhone();
		//usePhone() 메소드 호출
		usePhone(p1);
		//useHandPhone() 메소드 호출
		useHandPhone(p1);
		//useSmartPhone() 메소드 호출
		useSmartPhone(p1);
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








