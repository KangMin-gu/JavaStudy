package test.mypac;

public class Pen {
	//맴버필드 
	public String color;
	
	//생성자
	public Pen(String color) {
		this.color=color;
	}
	//맴버 메소드
	public Pen write() {
		System.out.println(this.color+" 색 Pen 으로 필기를 해요");
		return this;
	}
	public Pen draw() {
		System.out.println(color+" 색 Pen 으로 그림을 그려요");
		return this;
	}
}











