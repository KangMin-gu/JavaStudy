package test.main;
/*
 *  final 이라는 예약어는 
 *  변수 혹은 필드를 선언할때 붙이면 상수가 된다.
 *  그리고 관례상 final 을 붙인 변수나 필드의 식별자는 
 *  모두 대문자로 표기 한다. 
 *  
 *  ( 상수는 값 변경 불가 )
 */
public class MainClass01 {
	public static void main(String[] args) {
		int num=0;
		final int NUM2=0;
		
		//final 이 붙지 않은 변수는 값 변경 가능 
		num=10;
		//final 이 붙은 상수는 값 변경 불가
		//NUM2=10;
	}
}











