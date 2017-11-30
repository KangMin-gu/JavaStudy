package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		InputStream is=System.in;
		InputStreamReader isr=new InputStreamReader(is);
		//InputStreamReader 객체의 참조값을 생성자의 인자로 
		//전달하면서BufferedReader 객체 생성하기
		BufferedReader br=new BufferedReader(isr);
		try {
			System.out.print("한줄 입력:");
			//문자열 한줄 입력 받기 
			String line=br.readLine();
			System.out.println("- 입력한 문자열 -");
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}








