package test.main;

import test.mypac.Computer;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작됨");
		
		new Computer();
		
		Computer com1=new Computer();
		Computer com2=new Computer();
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}









