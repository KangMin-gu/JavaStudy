package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		useRemocon(()->{
			System.out.println("TV를 켜요");
		});
		
		useRemocon(()->{
			System.out.println("라디오를 켜요");
		});
		
		useRemocon(()->{
			System.out.println("불을 켜요");
		});
	}
	// Remocon type 의 참조값을 전달 받는 메소드 
	public static void useRemocon(Remocon r) {
		r.turnOn();
	}
}
