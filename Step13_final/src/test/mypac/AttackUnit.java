package test.mypac;

public class AttackUnit {
	// 숫자를 상수화 시키기 
	public static final int FIST=0;
	public static final int SWORD=1;
	public static final int GUN=2;
	
	private int weaponState=0;
	
	//무기의 상태를 바꾸는 메소드 
	public void setWeaponState(int weaponState) {
		this.weaponState = weaponState;
	}
	
	//공격하는 메소드 
	public void attack() {
		if(weaponState==AttackUnit.FIST) {
			System.out.println("주먹으로 공격해요!");
		}else if(weaponState==SWORD) {
			System.out.println("칼로 공격해요!");
		}else if(weaponState==GUN) {
			System.out.println("총으로 공격해요!");
		}
	}
}





