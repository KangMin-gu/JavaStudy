package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		Computer com1=new Computer();
		
		Computer com2=new Computer("2017.11.16");
		
		// Cpu type 을 전달 받는 생성자를 이용해서 
		// Computer 객체를 생성하고 참조값을 com3 라는 
		// 변수에 담아 보세요.
		Computer com3=new Computer(new Cpu());
		
		// String type 과 Cpu type 을 모두 전달 받는 생성자를
		// 이용해서 Computer 객체를 생성하고 참조값을 com4 라는 
		// 변수에 담아 보세요. 
		Computer com4=new Computer("2017", new Cpu());
		
	}
}













