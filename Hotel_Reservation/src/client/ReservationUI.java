package client;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import vo.ReserveInfo;
import vo.Room;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class ReservationUI extends JFrame implements ActionListener{
	Container container;

	JTextField tf_checkIn, tf_checkOut, tf_reservername,tf_reserverphone ;
	JPanel centerPanel, panel_reserve, reservePanel, panel_message;
	JPanel panel_reserver, panel_list, panel_btn;
	JLabel lbl_title, lbl_checkIn, lbl_checkOut, lbl_adultcount, lbl_childcount;
	JLabel lbl_adultbreakfast, lbl_childbreakfast, lbl_message, lbl_image ;
	JLabel lbl_reservername, lbl_meaningday;
	DefaultListModel model;
	JList roomList;
	JScrollPane scroll;
	JButton btn_ok, btn_cancel;

	JComboBox<Object> combo_adultcnt, combo_childcnt, combo_adultbreakfast, combo_childbreakfast;
	JComboBox<String> combo_jobList;

	ReservationClientManager manager = new ReservationClientManager();
	
	int roomN;
	Room selectedRoom;

	public ReservationUI() {
		setTitle("SE Hotel Reservation");
		setBounds(150, 150, 900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		container = getContentPane();
		container.setLayout(new BorderLayout(0, 0));

		lbl_title = new JLabel("SE Hotel Reservation System");
		lbl_title.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lbl_title.setOpaque(true);
		lbl_title.setBackground(new Color(153, 153, 255));
		lbl_title.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(lbl_title, BorderLayout.NORTH);

		centerPanel = new JPanel();
		container.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_reserve = new JPanel();
		panel_reserve.setSize(900, 400);
		panel_reserve.setPreferredSize(new Dimension(880, 200));
		centerPanel.add(panel_reserve);
		panel_reserve.setLayout(new GridLayout(0, 2, 30, 0));

		reservePanel = new JPanel();
		panel_reserve.add(reservePanel);
		reservePanel.setLayout(new GridLayout(6, 2, 5, 5));

		lbl_checkIn = new JLabel("Check In");
		lbl_checkIn.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_checkIn.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(lbl_checkIn);

		tf_checkIn = new JTextField();
		reservePanel.add(tf_checkIn);
		tf_checkIn.setHorizontalAlignment(SwingConstants.LEFT);
		tf_checkIn.setPreferredSize(new Dimension(150, 25));

		tf_checkIn.setText("YYYY/MM/DD");
		tf_checkIn.setColumns(15);

		lbl_checkOut = new JLabel("Check Out");
		lbl_checkOut.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_checkOut.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(lbl_checkOut);

		tf_checkOut = new JTextField();
		reservePanel.add(tf_checkOut);
		tf_checkOut.setText("YYYY/MM/DD");
		tf_checkOut.setColumns(15);

		lbl_adultcount = new JLabel("\uC219\uBC15\uC778\uC6D0(\uC131\uC778)");
		lbl_adultcount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_adultcount.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(lbl_adultcount);

		combo_adultcnt = new JComboBox<Object>();
		combo_adultcnt.setPreferredSize(new Dimension(150, 25));
		reservePanel.add(combo_adultcnt);
		combo_adultcnt.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));

		lbl_childcount = new JLabel("\uC219\uBC15\uC778\uC6D0(\uC5B4\uB9B0\uC774)");
		lbl_childcount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_childcount.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(lbl_childcount);

		combo_childcnt = new JComboBox();
		combo_childcnt.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(combo_childcnt);
		combo_childcnt.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));

		lbl_adultbreakfast = new JLabel("\uC870\uC2DD(\uC131\uC778)");
		lbl_adultbreakfast.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_adultbreakfast.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(lbl_adultbreakfast);

		combo_adultbreakfast = new JComboBox();
		combo_adultbreakfast.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(combo_adultbreakfast);
		combo_adultbreakfast.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));

		lbl_childbreakfast = new JLabel("\uC870\uC2DD(\uC5B4\uB9B0\uC774)");
		lbl_childbreakfast.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_childbreakfast.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(lbl_childbreakfast);

		combo_childbreakfast = new JComboBox();
		combo_childbreakfast.setPreferredSize(new Dimension(100, 30));
		reservePanel.add(combo_childbreakfast);
		combo_childbreakfast.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));

		panel_message = new JPanel();
		panel_reserve.add(panel_message);
		panel_message.setLayout(new BorderLayout(0, 0));

		lbl_message = new JLabel("\uC791\uC5C5\uC744 \uC120\uD0DD\uD574 \uC8FC\uC138\uC694");
		lbl_message.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_message.setForeground(Color.RED);
		lbl_message.setHorizontalAlignment(SwingConstants.CENTER);
		panel_message.add(lbl_message, BorderLayout.NORTH);

		lbl_image = new JLabel("New label");
		lbl_image.setIcon(new ImageIcon(ReservationUI.class.getResource("/sql/hotel.jpg")));
		panel_message.add(lbl_image, BorderLayout.CENTER);

		panel_reserver = new JPanel();
		centerPanel.add(panel_reserver);
		panel_reserver.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

		lbl_reservername = new JLabel("\uC608\uC57D\uC790 \uC131\uBA85");
		panel_reserver.add(lbl_reservername);

		tf_reservername = new JTextField();
		panel_reserver.add(tf_reservername);
		tf_reservername.setColumns(15);

		lbl_meaningday = new JLabel("\uC608\uC57D\uC790 \uC5F0\uB77D\uCC98");
		panel_reserver.add(lbl_meaningday);

		tf_reserverphone = new JTextField();
		panel_reserver.add(tf_reserverphone);
		tf_reserverphone.setColumns(15);

		// Hotel 정보 띄우기
		panel_list = new JPanel();
		panel_list.setLayout(new BorderLayout(0, 0));
		panel_list.setPreferredSize(new Dimension(880, 330));

		model = new DefaultListModel<>();
		roomList = new JList<>(model);

		scroll = new JScrollPane(roomList);
		panel_list.add(scroll, BorderLayout.CENTER);

		centerPanel.add(panel_list);

		panel_btn = new JPanel();
		container.add(panel_btn, BorderLayout.SOUTH);

		combo_jobList = new JComboBox();
		combo_jobList.setModel(new DefaultComboBoxModel(new String[] {"== \uC120\uD0DD\uD574 \uC8FC\uC138\uC694 ==", "\uC608\uC57D\uAC00\uB2A5 \uAC1D\uC2E4\uBCF4\uAE30", "\uC608\uC57D \uD558\uAE30", "\uC608\uC57D \uC870\uD68C", "\uC608\uC57D \uCDE8\uC18C", "\uC608\uC57D \uC218\uC815"}));
		panel_btn.add(combo_jobList);

		combo_jobList.addActionListener(this);

		btn_ok = new JButton("\uD655\uC778");
		btn_ok.addActionListener(this);
		panel_btn.add(btn_ok);

		btn_cancel = new JButton("\uCDE8\uC18C");
		btn_cancel.addActionListener(this);
		panel_btn.add(btn_cancel);
		
		initField(false);
		initButton(false);
		initReserver(false);

		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRoom = (Room) roomList.getSelectedValue();
			}
		});
		
		setVisible(true);
	}

	// 이벤트 처리를 위한 메소드
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JComboBox<String> combo;
		JButton btn;

		if(source instanceof JComboBox) {
			combo = (JComboBox<String>) source;
			int selected = combo.getSelectedIndex();

			switch(selected) {
			case 1:		// 예약 가능 객실 보기
				showList(manager.getRoomList());
				clearTextField();
				initField(false);
				initButton(false);
				initReserver(false);
				btn_ok.setText("확인");
				
				combo_jobList.setEnabled(true);
				
				lbl_message.setText("예약 가능한 객실 리스트입니다.");
				
				break;
			case 2:		// 예약하기
				showList(manager.getRoomList());
				
				clearTextField();
				initField(true);
				initButton(true);
				initReserver(true);
				btn_ok.setText("확인");
				combo_jobList.setEnabled(false);
				lbl_message.setText("예약할 정보를 입력하고 확인 버튼을 누르세요");

				break;
			case 3:		// 예약 조회
				clearTextField();
				initField(false);
				initButton(true);
				initReserver(true);
				
				btn_ok.setText("조회");
				
				combo_jobList.setEnabled(false);
				model.removeAllElements();
				
				lbl_message.setText("예약자의 이름과 정보를 입력");	
				
				break;
			case 4:		// 예약 취소
				clearTextField();
				initField(false);
				initButton(true);
				
				initReserver(true);
				
				model.removeAllElements();
				combo_jobList.setEnabled(false);
				btn_ok.setText("예약취소");
				
				lbl_message.setText("예약자의 이름과 정보를 입력");
				
				break;
			case 5:		// 예약수정
				clearTextField();
				
				initField(false);
				initButton(true);
				initReserver(true);
				
				btn_ok.setText("수정");
				
				model.removeAllElements();

				combo_jobList.setEnabled(false);
				
				lbl_message.setText("예약자의 이름과 정보를 입력");	
				
				break;				
			}
		} else {
			btn = (JButton) source;
			if(btn.getText().equals("확인")) {			// 예약
				reservation();
				
			} else if(btn.getText().equals("조회")) { 	// 예약 내용 조회 
				model.removeAllElements();
				confirm();
			} else if(btn.getText().equals("예약취소")) { // 예약  취소
				combo_jobList.setEnabled(false);
				
				cancelation();
			} else if(btn.getText().equals("수정")) {
				model.removeAllElements();

				roomN = confirm();
				showList(manager.getRoomList());
				
				initButton(true);
				btn.setText("수정완료");
				combo_jobList.setEnabled(false);
				
			} else if(btn.getText().equals("수정완료")) {	// 예약 정보 수정
				
				update(roomN);
			} else if(btn.getText().equals("취소")) {	// 작업을 취소
				clearTextField();
				initField(false);
				initButton(false);
				initReserver(false);
				combo_jobList.setSelectedIndex(0);
				combo_jobList.setEnabled(true);

				model.removeAllElements();
			}

		}
	}
	
	//================ 초기화 하는 메소드  ========================
	// 예약정보 입력 칸들을 활성화하거나 비활성화하는 메소드 
	public void initField(boolean status){
		tf_checkIn.setEditable(status);
		tf_checkOut.setEditable(status);

		combo_adultcnt.setEnabled(status);
		combo_childcnt.setEnabled(status);

		combo_adultbreakfast.setEnabled(status);
		combo_childbreakfast.setEnabled(status);
	}
	
	// 예약자 정보를 활성화하거나 비활성화 하는 메서드
	public void initReserver(boolean status) {
		tf_reservername.setEditable(status);
		tf_reserverphone.setEditable(status);
	}

	// 버튼들을 활성화하거나 비활성화하는 메소드  
	public void initButton(boolean status){
		btn_ok.setText("확인");
		btn_ok.setEnabled(status);
		btn_cancel.setEnabled(status);
	}

	// 한 줄 글 상자를 지우는 메소드 
	public void clearTextField(){
		tf_checkIn.setText("YYYY/MM/DD");
		tf_checkOut.setText("YYYY/MM/DD");
		tf_reservername.setText("");
		tf_reserverphone.setText("");
	}

	//===================================================
	// 조회한 객실 리스트를 화면에 보여주는 메소드 
	public void showList(ArrayList<Room> room_list){
		model.removeAllElements();

		for(Room room:room_list)
			model.addElement(room);
	}
	
	// 예약하기 메소드
	public void reservation() {
		// 완성하시오
		String reserverName, reserverPhone, checkIn, checkOut;
		int reserveCode, adultCount, childCount, adultBreakfast, childBreakfast, roomNum, meaningDay, totalPrice;
		reserverName = reserverPhone = checkIn = checkOut = null;
		reserveCode = adultCount = childCount = adultBreakfast = childBreakfast = roomNum = meaningDay = totalPrice = 0;
		
		try {
			reserverName = tf_reservername.getText();
			reserverPhone = tf_reserverphone.getText();
			checkIn = tf_checkIn.getText();
			checkOut = tf_checkOut.getText();
			reserveCode = 0;
			adultCount = Integer.parseInt((String)combo_adultcnt.getSelectedItem());
			childCount = Integer.parseInt((String)combo_childcnt.getSelectedItem());
			adultBreakfast = Integer.parseInt((String)combo_adultbreakfast.getSelectedItem());;
			childBreakfast = Integer.parseInt((String)combo_childbreakfast.getSelectedItem());;
			roomNum = selectedRoom.getRoomNum();
			meaningDay = 0;
			totalPrice = 0;
			
			if (!(reserverName.equals("")) && !(reserverPhone.equals("")) && !(checkIn.equals("")) && !(checkOut.equals(""))) {
				ReserveInfo r = new ReserveInfo
						(reserveCode, reserverName, reserverPhone, roomNum, checkIn, checkOut, meaningDay, adultCount, childCount, adultBreakfast, childBreakfast, totalPrice);
				boolean result = manager.insertReserve(r);
				if (result) {
					JOptionPane.showMessageDialog(this, "예약 되었습니다.");
					clearTextField();
					initField(false);
					initButton(false);
					initReserver(false);
					combo_jobList.setSelectedIndex(0);
					combo_jobList.setEnabled(true);
					model.removeAllElements();
				} else {
					JOptionPane.showMessageDialog(this, "체크아웃 날짜는 체크인 날짜보다 빠르거나 같을 수 없습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "예약을 위한 데이터를 입력해주시기 바랍니다.");
			}
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "예약하실 방을 선택해주세요");
		}
		
	}

	// 예약 수정 메소드
	public void update(int roomN) {
		// 완성하시오
		String reserverName, reserverPhone, checkIn, checkOut;
		int reserveCode, adultCount, childCount, adultBreakfast, childBreakfast, roomNum, meaningDay, totalPrice;
		
		reserverName = reserverPhone = checkIn = checkOut = null;
		reserveCode = adultCount = childCount = adultBreakfast = childBreakfast = roomNum = meaningDay = totalPrice = 0;
		
		try {
			reserverName = tf_reservername.getText();
			reserverPhone = tf_reserverphone.getText();
			checkIn = tf_checkIn.getText();
			checkOut = tf_checkOut.getText();
			reserveCode = 0;
			adultCount = Integer.parseInt((String)combo_adultcnt.getSelectedItem());
			childCount = Integer.parseInt((String)combo_childcnt.getSelectedItem());
			adultBreakfast = Integer.parseInt((String)combo_adultbreakfast.getSelectedItem());;
			childBreakfast = Integer.parseInt((String)combo_childbreakfast.getSelectedItem());;
			if (selectedRoom == null) {
				roomNum = roomN;
			} else {
				roomNum = selectedRoom.getRoomNum();
			}
			meaningDay = 0;
			totalPrice = 0;
			
			if (!(reserverName.equals("")) && !(reserverPhone.equals("")) && !(checkIn.equals("")) && !(checkOut.equals(""))) {
				ReserveInfo r = new ReserveInfo
						(reserveCode, reserverName, reserverPhone, roomNum, checkIn, checkOut, meaningDay, adultCount, childCount, adultBreakfast, childBreakfast, totalPrice);
				boolean result = manager.updateReserve(r);
				if (result) {
					JOptionPane.showMessageDialog(this, "수정 되었습니다.");
					clearTextField();
					initField(false);
					initButton(false);
					initReserver(false);
					combo_jobList.setSelectedIndex(0);
					combo_jobList.setEnabled(true);
					model.removeAllElements();
				} else {
					JOptionPane.showMessageDialog(this, "수정 실패");
				}
			} else {
				JOptionPane.showMessageDialog(this, "예약 수정을 위한 데이터를 입력해주시기 바랍니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	// 예약 취소 메서드
	public void cancelation() {
		// 완성하시오
		ReserveInfo info = null;
		String reserverName = tf_reservername.getText();
		String reserverPhone = tf_reserverphone.getText();
		info = manager.confirmReserve(reserverName, reserverPhone);
		if (info != null) {
			display(info);
			
			model.addElement(info);
			int result = JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?", "예약취소", 0);
			System.out.println(result);
			if (result == 0) {
				boolean resu = manager.deleteReserve(reserverName, reserverPhone);
				if (resu) {
					JOptionPane.showMessageDialog(this, "삭제 되었습니다.");
					clearTextField();
					initField(false);
					initButton(false);
					initReserver(false);
					combo_jobList.setSelectedIndex(0);
					combo_jobList.setEnabled(true);
					model.removeAllElements();
				} else {
					JOptionPane.showMessageDialog(this, "삭제 실패");
					clearTextField();
					initField(false);
					initButton(false);
					initReserver(false);
					combo_jobList.setSelectedIndex(0);
					combo_jobList.setEnabled(true);
					model.removeAllElements();
				}
			} else {
				clearTextField();
				initField(false);
				initButton(false);
				initReserver(false);
				combo_jobList.setSelectedIndex(0);
				combo_jobList.setEnabled(true);
				model.removeAllElements();
			}
		}

	}

	// 예약 내용 조회 메소드
	public int confirm() {
		ReserveInfo info = null;
		// 완성하시오 
		String reserverName = tf_reservername.getText();
		String reserverPhone = tf_reserverphone.getText();
		info = manager.confirmReserve(reserverName, reserverPhone);

		display(info);
		model.addElement(info);
		return info.getRoomNum();
	}

	// 예약 정보를 리스트에 출력한다.
	public void display(ReserveInfo info) {
		initField(true);

		tf_checkIn.setText(info.getCheckIn());
		tf_checkOut.setText(info.getCheckOut());
		combo_adultcnt.setSelectedIndex(info.getAdultCount()-1);
		combo_childcnt.setSelectedIndex(info.getChildCount());
		combo_adultbreakfast.setSelectedIndex(info.getAdultBreakfast());
		combo_childbreakfast.setSelectedIndex(info.getChildBreakfast());
		
		tf_reservername.setText(info.getReserverName());
		tf_reserverphone.setText(info.getReserverPhone());
	}

	public static void main(String[] args) {
		new ReservationUI();
	}

}
