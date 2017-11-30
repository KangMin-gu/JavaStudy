package test.main;

import test.mypac.MyUtil;

public class MainClass01 {
	public static void main(String[] args) {
		// MyUtil 클래스에 정의한 showVersion() 메소드를 
		// 호출해 보세요.
		MyUtil.showVersion();
		
		// MyUtil 클래스에 정의한 sendMessage() 메소드를 
		// 호출해 보세요.
		MyUtil u=new MyUtil();
		u.sendMessage();
		
		MyUtil u2=new MyUtil();
		u2.sendMessage();
		
		new MyUtil().sendMessage();
		
	}
}

















