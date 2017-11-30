package test.main;

import test.armory.Bullet;
import test.armory.SniperGun;

public class MainClass11 {
	public static void main(String[] args) {
		SniperGun gun1=new SniperGun(new Bullet());
		gun1.fire();
	}
}
