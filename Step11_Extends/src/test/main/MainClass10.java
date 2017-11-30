package test.main;

import test.armory.Bullet;
import test.armory.MachineGun;

public class MainClass10 {
	public static void main(String[] args) {
		MachineGun gun1=new MachineGun(new Bullet());
		gun1.fire();
		gun1.autoFire();
	}
}
