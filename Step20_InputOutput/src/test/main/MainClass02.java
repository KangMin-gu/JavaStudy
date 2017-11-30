package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 *  [ InputStreamReader ]
 *  
 *  - 문자열을 읽어들일때 사용한다.
 *  - 2 byte 처리 스트림
 *  - 한글을 포함한 모든 문자 1글자를 처리할수 있다. 
 */
public class MainClass02 {
	public static void main(String[] args) {
		//키보드와 연결된 객체의 참조값 
		InputStream is=System.in;
		
		InputStreamReader isr=new InputStreamReader(is);
		
		try {
			System.out.print("한글자 입력:");
			int keyCode=isr.read();
			//입력받은 문자 코드값 출력
			System.out.println("keyCode:"+keyCode);
			//코드를 char 로 casting
			char ch=(char)keyCode;
			//변환된 문자 출력
			System.out.println("입력한 글자:"+ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}












