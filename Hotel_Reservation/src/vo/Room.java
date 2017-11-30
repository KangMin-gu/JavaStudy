package vo;

import java.io.Serializable;

/**
 * <pre>
 * 
 * </pre>
 * */
public class Room implements Serializable {

	private int roomId;  		// 객실 아이디
	private int roomNum;	 	// 객실 번호
	private String roomType; 	// 객실 종류 'Standard', 'Premier', 'Suite'
	private int roomSize;		// 객실 크기 46, 63, 76
	private String viewType;	// 객실 밖에 보이는 뷰의 종류 'Mountain', 'Ocean', 'Garden'
	private int price;			// 하루 숙박 가격
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 주어진 이름, 나이, 주민번호 정보를 가지고 새로운 Human 객체를 생성한다.
	 * @param name 구성원의 이름
	 * @param age 구성원의 나이
	 * @param jumin 구성원의 주민번호
	 * */
	public Room(int roomId, int roomNum, String roomType, int roomSize, String viewType, int price) {
		super();
		this.roomId = roomId;
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.roomSize = roomSize;
		this.viewType = viewType;
		this.price = price;
	}

	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		String temp = String.format("%d호실 : %10s, %4d평방미터, (%s), 숙박료(1박) %d원%n",
				roomNum, roomType, roomSize, viewType, price);
		return temp;
	}
}
