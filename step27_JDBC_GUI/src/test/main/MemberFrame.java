package test.main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberFrame extends JFrame{
	//맴버필드 정의하기
	JTextField inputNum, inputName, inputAddr;
	JButton saveBtn, deleteBtn, updateBtn;
	
	//생성자
	public MemberFrame() {
		initUI();
	}
	//UI 초기화 작업 메소드
	public void initUI() {
		
		//레이아웃 설정
		setLayout(new BorderLayout());
		//상단 페널 객체 생성
		JPanel topPanel=new JPanel();
		
		//레이블 객체 생성
		JLabel label1=new JLabel("번호");
		JLabel label2=new JLabel("이름");
		JLabel label3=new JLabel("주소");
		
		//텍스트 필드 객체 생성
		inputNum=new JTextField(10);
		inputName=new JTextField(10);
		inputAddr=new JTextField(10);
		
		saveBtn=new JButton("저장");
		deleteBtn=new JButton("삭제");
		updateBtn=new JButton("수정");
		
		
		//페널에 컴포넌트 추가 하기 
		topPanel.add(label1);
		topPanel.add(inputNum);
		topPanel.add(label2);
		topPanel.add(inputName);
		topPanel.add(label3);
		topPanel.add(inputAddr);
		topPanel.add(saveBtn);
		topPanel.add(deleteBtn);
		topPanel.add(updateBtn);
		
		//프레임의 상단에 페널 배치하기
		add(topPanel, BorderLayout.NORTH);
		
		//프레임 위치와 크기 설정
		setBounds(200, 200, 800, 500);
		//보이도록 설정
		setVisible(true);
		//프레임을 닫았을때 프로세스가 완전히 종료되도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//메인 메소드
	public static void main(String[] args) {
		new MemberFrame();
	}
}
