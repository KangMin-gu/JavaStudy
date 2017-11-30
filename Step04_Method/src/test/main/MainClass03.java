package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		//showNum() 메소드를 호출 해 보세요.
		MainClass03.showNum(10);
		
		int num=20;
		MainClass03.showNum(num);
	}
	
	public static void showNum(int num) {
		System.out.println("num:"+num);
	}
}
