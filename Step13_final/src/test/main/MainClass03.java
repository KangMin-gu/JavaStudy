package test.main;

import test.mypac.AttackUnit;

public class MainClass03 {
	public static void main(String[] args) {
		// import 된 AttackUnit 객체 생성 
		AttackUnit unit1=new AttackUnit();
		// 무기의 상태 설정 
		unit1.setWeaponState(AttackUnit.GUN);
		// 공격
		unit1.attack();
	}
}
