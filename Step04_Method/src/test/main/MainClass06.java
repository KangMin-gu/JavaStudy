package test.main;

// 다른 페키지에 있는 클래스는 import 해야 사용할 수 있다. 
import test.mypac.YourUtil;

public class MainClass06 {
	public static void main(String[] args) {
		// 메세지를 전송해 보세요.
		MyUtil.sendMessage();
		// 화면을 캪쳐해 보세요.
		MyUtil.screenCapture();
		
		// 파일을 다운로드해 보세요.
		YourUtil.fileDown();
		// 파일을 업로드해 보세요.
		YourUtil.fileUp();
	}
}	








