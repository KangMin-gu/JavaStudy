package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.FriendsDao;
import test.dao.MemberDao;
import test.dto.FriendsDto;
import test.dto.MemberDto;

public class FriendsFrame extends JFrame implements ActionListener  {
	JTextField inputNum, inputName, intputPhone;
	JButton saveBtn, deleteBtn, updateBtn;
	DefaultTableModel model = null;
	JTable table;
	
	public FriendsFrame() {
		initUI();
	}
	// UI 초기화 작업 메소드
	public void initUI() {
		// 레이아웃 설정
		setLayout(new BorderLayout());
		// 상단 페널 객체 생성
		JPanel topPanel = new JPanel();

		// 레이블 객체 생성
		JLabel label1 = new JLabel("번호");
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("전화번호");

		// 텍스트 필드 객체 생성
		inputNum = new JTextField(10);
		inputName = new JTextField(10);
		intputPhone = new JTextField(10);

		saveBtn = new JButton("저장");
		deleteBtn = new JButton("삭제");
		updateBtn = new JButton("수정");

		// 버튼에 ActionListener 등록
		saveBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);

		// 버튼에 action command 등록
		saveBtn.setActionCommand("save");
		deleteBtn.setActionCommand("delete");
		updateBtn.setActionCommand("update");

		inputNum.setEditable(false);

		// 페널에 컴포넌트 추가 하기
		topPanel.add(label1);
		topPanel.add(inputNum);
		topPanel.add(label2);
		topPanel.add(inputName);
		topPanel.add(label3);
		topPanel.add(intputPhone);
		topPanel.add(saveBtn);
		topPanel.add(deleteBtn);
		topPanel.add(updateBtn);

		// 프레임의 상단에 페널 배치하기
		add(topPanel, BorderLayout.NORTH);
		// ------------- 테이블 만들기 -----------
		// 테이블 칼럼 명을 String[] 에 담는다.
		String[] colNames = { "번호", "이름", "전화번호", "날짜" };
		// 기본 테이블 모델 객체 생성
		model = new DefaultTableModel(colNames, 0);
		// JTable 객체 생성
		table = new JTable();
		table.setModel(model);
		// 스크롤 가능한 패널 객체
		JScrollPane sPanel = new JScrollPane(table);
		// 페널을 프레임의 가운데에 배치
		add(sPanel, BorderLayout.CENTER);
		// ------------- 테이블 만들기 -----------
		// 프레임의 위치와 크기 설정
		setBounds(200, 200, 800, 500);
		// 보이도록 설정
		setVisible(true);
		// 프레임을 닫았을때 프로세스가 완전히 종료되도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		displayMember();
	}

	// 메인 메소드
	public static void main(String[] args) {
		new FriendsFrame();
	}

	// ActionListener 인터페이스 때문에 구현한 메소드
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 이벤트가 일어난 버튼의 action command를 읽어온다.
		String command = ae.getActionCommand();

		if (command.equals("save")) {
			// 입력한 이름과 전번 읽어오기
			String name = inputName.getText();
			String phone = intputPhone.getText();

		
			FriendsDto dto = new FriendsDto();
			dto.setName(name);
			dto.setPhone(phone);

			
			FriendsDao dao = FriendsDao.getInstance();
			dao.insert(dto);

		} else if (command.equals("delete")) { // 삭제버튼 눌렀을때
			
			int result = JOptionPane.showConfirmDialog(this, "진짜 삭제할껴?");
			
			if (result != JOptionPane.YES_OPTION) {
				return;// 메소드 종료.
			}
			// 선택된 row의 인덱스를 읽어온다.
			int selectedIndex = table.getSelectedRow();
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택하세요");
				return;// 메소드 종료
			}
			// 삭제할 row에 있는 회원 번호를 읽어온다.
			int num = (int) table.getValueAt(selectedIndex, 0);
			// DB 에서 해당 회원정보를 삭제한다.
			FriendsDao dao = FriendsDao.getInstance();
			dao.delete(num);

		} else if (command.equals("update")) {
			// 선택된 row의 인덱스를 읽어온다.
			int selectedIndex = table.getSelectedRow();
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(this, "수정할 row를 선택하세요");
				return;// 메소드 종료
			}
			int num = (int) table.getValueAt(selectedIndex, 0);
			String name = (String) table.getValueAt(selectedIndex, 1);
			String phone = (String) table.getValueAt(selectedIndex, 2);
			String date = (String) table.getValueAt(selectedIndex, 3);
			FriendsDto dto = new FriendsDto(num, name, phone, date);
			// DB 에 수정 반영한다.
			FriendsDao.getInstance().update(dto);
			JOptionPane.showMessageDialog(this, "수정하였습니다.");
		}
		// 회원정보 다시 출력
		displayMember();

	}// actionPerformed

	// DB에 있는 회원정보를 JTable에 출력하는 메소드
	public void displayMember() {

		// 회원정보를 읽어온다.
		FriendsDao dao = FriendsDao.getInstance();
		List<FriendsDto> list = dao.getList();
		// 테이블의 내용을 지우고
		model.setRowCount(0);
		// 다시 출력
		for (FriendsDto tmp : list) {// 반복문돌면서
			Object[] rowData = { tmp.getNum(), tmp.getName(), tmp.getPhone(), tmp.getDate() };
			model.addRow(rowData);// row 추가
		}
	}
}
