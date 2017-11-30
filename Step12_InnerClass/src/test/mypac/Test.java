package test.mypac;
/*
 *   클래스 안에 클래스를 정의할 수 있다.
 */
public class Test {
	
	// Gura Type 객체를 생성해서 리턴해 주는 메소드 
	public Gura getGura() {
		return new Gura();
	}
	// Monkey Type 객체를 생성해서 리턴해 주는 메소드
	public Monkey getMonkey() {
		return new Monkey();
	}
	
	//내부 클래스 (Inner Class)
	public class Gura{
		public void say() {
			System.out.println("안녕 난 구라야!");
		}
	}
	//내부 클래스
	public class Monkey{
		public void say() {
			System.out.println("안녕 난 원숭이야!");
		}
	}
}
