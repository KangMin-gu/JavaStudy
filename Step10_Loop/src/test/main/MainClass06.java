package test.main;

import test.mypac.Pen;

public class MainClass06 {
	public static void main(String[] args) {
		// Pen 객체를 생성해서 write() 메소드를 호출해 보세요.
		Pen p1=new Pen("red");
		p1.write().write().write();
		
		Pen p2=new Pen("blue");
		p2.write().draw().write();
	}
}












