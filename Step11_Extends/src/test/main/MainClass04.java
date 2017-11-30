package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		HandPhone p1=new HandPhone();
		
		// 원래 HandPhone 객체의 참조값 이기 때문에 
		// SmartPhone 으로 casting 은 실행시에 오류가 발생한다.
		SmartPhone p2=(SmartPhone)p1;
		p2.doInternet();
	}
}











