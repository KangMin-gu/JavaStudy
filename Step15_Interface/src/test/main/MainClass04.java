package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;
import test.mypac.YourRemocon;

public class MainClass04 {
	public static void main(String[] args) {
		//익명의 local inner class 를 이용해서 객체를 생성하고
		//참조값을 Remocon type 변수에 담기 
		Remocon r1=new Remocon() {
			@Override
			public void up() {
				System.out.println("머리를 올려요");
			}
			@Override
			public void down() {
				System.out.println("머리를 내려요");
			}
		};
		
		useRemocon(r1);
		
		useRemocon(new Remocon() {
			@Override
			public void up() {
				System.out.println("다리를 올려요");
			}
			@Override
			public void down() {
				System.out.println("다리를 내려요");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}











