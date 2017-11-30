package test.main;
/*
 *  [ Java 기본 데이터 type ]
 *  
 *  3. 문자형 (char)
 *  
 *  - 65536 가지의 코드값을 가질수 있어서 전세계에서 사용하는 문자
 *  한글자를 표현 할 수 있다. 
 *  
 */
public class MainClass04 {
	public static void main(String[] args) {
		//char 형 변수 선언과 동시에 값 대입하기
		char ch1='a';
		char ch2='1';
		char ch3='@';
		char ch4='가';
		char ch5='쀍';
		
		//내부적으로는 정수 code 값으로 처리 한다.
		int code1=ch1; //자동 casting 되어서 담긴다. 
		int code2=ch2;
		int code3=ch3;
		int code4=ch4;
	}
}












