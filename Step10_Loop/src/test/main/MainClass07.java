package test.main;

import test.mypac.Pen;

public class MainClass07 {
	public static void main(String[] args) {
		// Pen type 객체를 담을수 있는 방 5개짜리 배열 객체 생성
		Pen[] pens=new Pen[3];
		//각각의 방에 Pen 객체를 생성해서 참조값 대입
		pens[0]=new Pen("red");
		pens[1]=new Pen("green");
		pens[2]=new Pen("blue");		
		//반복문 이용해서 배열에 저장된 모든 Pen 객체의 
		// write() 메소드와 draw() 메소드 호출하기 
		for(int i=0; i<pens.length; i++) {
			Pen tmp=pens[i];
			tmp.write();
			tmp.draw();
		}
		System.out.println("--- 확장 for 문 ---");
		for(Pen tmp:pens) {
			tmp.write().draw();
		}
	}
}






























