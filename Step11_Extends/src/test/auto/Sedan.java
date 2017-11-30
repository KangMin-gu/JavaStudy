package test.auto;

public class Sedan extends Car{
	//부모의 메소드 재정의 하기 
	@Override
	public void drive() {
		System.out.println("부드럽게 달려요");
	}
}
