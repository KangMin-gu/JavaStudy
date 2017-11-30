package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;
import test.mypac.YourRemocon;

public class MainClass03 {
	public static void main(String[] args) {
		// local inner class
		class OurRemocon implements Remocon{
			@Override
			public void up() {
				System.out.println("채널을 올려요!");
			}
			@Override
			public void down() {
				System.out.println("체널을 내려요!");
			}
		}
		//OurRemocon 객체 생성해서 Remocon 인터페이스 type 으로
		//참조값 받기 
		Remocon r1=new OurRemocon();
		
		useRemocon(r1);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}











