package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 메소드 내부에서도 클래스를 정의할수 있다.
		// Local Inner Class
		class Gura{
			public void say() {
				System.out.println("안녕 나는 Gura 야~");
			}
		}
		
		Gura g=new Gura();
		g.say();
		
	}
}
