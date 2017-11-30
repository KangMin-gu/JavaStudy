package test.main;

import java.io.IOException;
import java.io.InputStream;

/*
 *  [ InputStream ]
 *  - 1byte 처리 스트림(byte 알갱이의 흐름)
 *  - 문자의 경우는 영문자 대소문자, 숫자, 특수문자 한글자를 
 *    읽어들일수 있다.
 *  - 한글은 처리 불가  
 */
public class MainClass01 {
	public static void main(String[] args) {
		/*
	, 	 *  키보드로 부터 한개의 글자 코드를 입력 받아서 콘솔에
		 *  출력해보기
		 */
		//키보드로 부터 입력받을수 있는 
		//객체의 참조값 얻어와서 변수에 담기 
		InputStream is = System.in;
		
		System.out.print("한글자 입력:");
		try {
			//입력한 키의 코드값을 받아온다. 
			int keyCode = is.read();
			System.out.println("keyCode:"+keyCode);
			//코드에 해당되는 문자을 얻어온다.
			char ch = (char)keyCode;
			System.out.println("char Type 으로 변환한값:"+ch);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}




