package test.armory;

public class SniperGun extends Gun{
	
	//생성자 
	public SniperGun(Bullet bullet) {
		super(bullet);
		
	}
	//fire() 메소드 재정의하기 
	@Override
	public void fire() {
		/*
		 * super 는 부모객체의 참조값을 가리키는 예약어 이다.
		 * super.fire() 재정의의 대상이된 부모 메소드를 
		 * 호출하는 표현식이다.
		 */
		super.fire();
		
		System.out.println("좀더 멀리 정밀하게 빵~");
	}

}








