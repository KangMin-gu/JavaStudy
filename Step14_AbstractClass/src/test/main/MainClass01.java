package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;
import test.mypac.YourWeapon;

public class MainClass01 {
	public static void main(String[] args) {
		MyWeapon w1=new MyWeapon();
		w1.prepare();
		w1.attack();
		
		System.out.println("-----");
		
		YourWeapon w2=new YourWeapon();
		w2.prepare();
		w2.attack();
		
		System.out.println("-------");
		
		useWeapon(w1);
		
		System.out.println("--------");
		
		useWeapon(w2);
	}
	// 추상 클래스 Type 을 인자로 전달 받는 메소드 
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}






