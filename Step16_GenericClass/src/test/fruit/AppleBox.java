package test.fruit;

public class AppleBox {
	//맴버필드 
	private Apple item;
	//객체를 저장하는 메소드
	public void push(Apple item) {
		this.item=item;
	}
	//객체를 리턴해주는 메소드
	public Apple pull() {
		return item;
	}
}
