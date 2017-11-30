package vo;

import java.io.Serializable;

public class ReserveInfo implements Serializable {
	private int reserveCode;
	private String reserverName;
	private String reserverPhone;
	private int roomNum;
	private String checkIn;
	private String checkOut;
	private int meaningDay;
	private int adultCount;
	private int childCount;
	private int adultBreakfast;
	private int childBreakfast;
	private int totalPrice;
	
	public ReserveInfo() {
		// TODO Auto-generated constructor stub
	}

	public ReserveInfo(int reserveCode, String reserverName, String reserverPhone, int roomNum, String checkIn,
			String checkOut, int meaningDay, int adultCount, int childCount, int adultBreakfast, int childBreakfast,
			int totalPrice) {
		super();
		this.reserveCode = reserveCode;
		this.reserverName = reserverName;
		this.reserverPhone = reserverPhone;
		this.roomNum = roomNum;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.meaningDay = meaningDay;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.adultBreakfast = adultBreakfast;
		this.childBreakfast = childBreakfast;
		this.totalPrice = totalPrice;
	}

	public int getReserveCode() {
		return reserveCode;
	}

	public void setReserveCode(int reserveCode) {
		this.reserveCode = reserveCode;
	}

	public String getReserverName() {
		return reserverName;
	}

	public void setReserverName(String reserverName) {
		this.reserverName = reserverName;
	}

	public String getReserverPhone() {
		return reserverPhone;
	}

	public void setReserverPhone(String reserverPhone) {
		this.reserverPhone = reserverPhone;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getCheckIn() {
		return checkIn.replace("-", "/").substring(0, 10);
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut.replace("-", "/").substring(0, 10);
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getMeaningDay() {
		return meaningDay;
	}

	public void setMeaningDay(int meaningDay) {
		this.meaningDay = meaningDay;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public int getAdultBreakfast() {
		return adultBreakfast;
	}

	public void setAdultBreakfast(int adultBreakfast) {
		this.adultBreakfast = adultBreakfast;
	}

	public int getChildBreakfast() {
		return childBreakfast;
	}

	public void setChildBreakfast(int childBreakfast) {
		this.childBreakfast = childBreakfast;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
// 2016/01/01-1212
	@Override
	public String toString() {
		return "예약번호 : " + reserveCode + " "+ reserverName + ", " + reserverPhone + ", 객실번호 : " + roomNum 
				+ ", 체크인 날짜 : " + checkIn + ", 체크아웃 날짜 : " + checkOut
				+ ", 숙박일 : " + meaningDay + ", 성인 : " + adultCount + ", 어린이 : " + childCount
				+ ", 조식 (성인) : " + adultBreakfast + ", 조식 (어린이) : " + childBreakfast + ", 총 금액 : " + totalPrice ;
	}
}
