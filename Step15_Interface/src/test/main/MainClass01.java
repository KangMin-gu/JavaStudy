package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		
		// Remocon 인터페이스 type 을 담을 지역변수 만들기 
		Remocon r1=null;
		// Remocon type 의 참조값이 필요 하다면?
		r1=new MyRemocon();
		useRemocon(r1);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}




