package test.main;
/*
 *  [ Java 기본 데이터 type ]
 *  
 *  1. 숫자형
 *  
 *  정수형 : byte, short, int, long
 *  
 *  - byte 변수명;  // -128 ~ 127
 *  - short 변수명;  // -32768 ~ 32767
 *  - int  변수명; // -2147483648 ~ 2147483647
 *  - long 변수명; // -9223372036854775808 ~ 9223372036854775807
 *  
 *  실수형 : float, double
 *  
 *  - float 변수명; // 1.40129846432481707e-45 ~ 3.40282346638528860e+38
 *  - double 변수명; //4.94065645841246544e-324d ~ 1.79769313486231570e+308d
 */
public class MainClass01 {
	// 실행순서가 시작되는 특별한 main 메소드 
	public static void main(String[] args) {
		//정수형 변수 종류별로 선언하고 값 대입하기
		byte iByte=10;
		short iShort=10;
		int iInt=10;
		long iLong=10;
		
		int tmp=iByte;
		// casting 연산자를 이용하기 
		byte tmp2=(byte)iInt;
		
		//실수형 변수 종류별로 선언하고 값 대입하기
		float num1=10.1f;
		double num2=10.1d;
		double num3=10.1; // d 생략하면 double type 이다.
		
		// float type 을 double type 으로 담기 (가능)
		double tmp3=num1;
		
		// casting 연산자를 사용해야 담을 수 있다. 
		float tmp4=(float)num2;
	}
}












