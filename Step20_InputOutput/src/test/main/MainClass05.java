package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainClass05 {
	public static void main(String[] args) {
		OutputStream os=System.out;
		//OutputStreamWriter 객체 생성 
		OutputStreamWriter osw=new OutputStreamWriter(os);
		try {
			//String 출력 
			osw.write("문자열 출력");
			//방출
			osw.flush();
			//char[] 객체 생성 
			char[] chars={'가','나','다','라'};
			//char[] 출력 
			osw.write(chars);
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






