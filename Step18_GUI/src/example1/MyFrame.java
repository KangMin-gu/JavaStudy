package example1;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	//생성자
	public MyFrame() {
		// setBounds(x, y, width, height)
		setBounds(100, 100, 500, 500);
		// x 를 눌러서 창을 닫았을때 프로세스가 종료 되도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프레임 객체가 화면에 보이도록 
		setVisible(true);
	}
	
	//메인 메소드
	public static void main(String[] args) {
		//MyFrame() 객체 생성하기 
		new MyFrame();
	}
}




