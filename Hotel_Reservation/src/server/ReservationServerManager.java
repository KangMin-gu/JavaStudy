package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manager.ReservationManager;
import vo.ReserveInfo;
import vo.Room;


/**
 * <pre>
 * SE Hotel 예약 프로그램의 업무 로직을 관리하는 클래스
 * 주요 기능으로는 다음과 같다.
 * 1. 객실 검색
 * 2. 객실 예약
 * 3. 예약 객실 조회
 * 4. 예약 객실 수정
 * 5. 예약 객실 삭제
 * </pre>
 * */
public class ReservationServerManager implements ReservationManager {
	ArrayList<ReserveInfo> reserveList;	
	ArrayList<Room> roomList;	

	Connection conn;
	ResultSet rs;
	
	private final int ADULTMEALPRICE = 30000;
	private final int CHILDMEALPRICE = 15000;

	/**
	 * 예약 가능한 모든 객실 목록을 반환한다.
	 * @return 예약 가능한 모든 객실 목록을 반환한다. 이미 예약이 되었는 경우는 목록에 포함되지 않아야 한다.
	 * */	
	@Override
	public ArrayList<Room> getRoomList() {
		roomList = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ROOM WHERE ROOMNUM NOT IN (SELECT ROOMNUM FROM RESERVEINFO)");
			rs = ps.executeQuery();
			while (rs.next()) {
				int roomId = rs.getInt("ROOMID");  		
				int roomNum = rs.getInt("ROOMNUM");	 
				String roomType = rs.getString("ROOMTYPE"); 	
				int roomSize = rs.getInt("ROOMSIZE");		
				String viewType = rs.getString("VIEWTYPE"); 	
				int price = rs.getInt("PRICE");
				
				Room r = new Room(roomId, roomNum, roomType, roomSize, viewType, price);
				roomList.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return roomList;
	}

	/**
	 * 예약해 놓은 객실의 정보를 리스트를 조회한다.
	 * @param 예약자의 이름과 전화번호
	 * @return 예약된 정보가 있을 경우 예약 정보를, 예약 정보가 없을 경우 null을 반환한다.
	 * */
	
	@Override
	public ReserveInfo confirmReserve(String reserverName, String reserverPhone) {
		ReserveInfo info = null;
		// 완성하시오
		ResultSet rs = null;
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM RESERVEINFO WHERE RESERVERNAME = ? AND RESERVERPHONE = ?");
			ps.setString(1, reserverName);
			ps.setString(2, reserverPhone);
			rs = ps.executeQuery();
			while (rs.next()) {

			int reserveCode = rs.getInt("RESERVECODE");  		
			int roomNum = rs.getInt("ROOMNUM");	 
			String checkIn = rs.getString("CHECKIN");
			String checkOut = rs.getString("CHECKOUT");
			int meaningDay = rs.getInt("MEANINGDAY");
			int adultCount = rs.getInt("ADULTCOUNT");
			int childCount = rs.getInt("CHILDCOUNT");
			int adultBreakfast = rs.getInt("ADULTBREAKFAST");
			int childBreakfast = rs.getInt("CHILDBREAKFAST");
			int totalPrice = rs.getInt("TOTALPRICE");
			info = new ReserveInfo(reserveCode, reserverName, reserverPhone, roomNum, checkIn, checkOut, meaningDay, adultCount, childCount, adultBreakfast, childBreakfast, totalPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return info;
	}

	/**
	 * 새로운 객실 예약 정보를 등록한다.
	 * meanDay() 메소드를 이용하여 숙박일수를 DB로부터 얻어와야 한다.
	 * roomPrice() 메서드를 이용하여 객실 가격을 DB로부터 얻어와야 한다.
	 * 객실 총 사용료(totalPrice) = (숙박일 수 * 객실가격) + (어른 조식 * ADULTMEALPRICE * 숙박일수)
	 * 
	 * @param 등록할 예약정보 객체 ReserveInfo
	 * @return 등록 여부 리턴. 등록이 되었으면 true, 등록이 실패했으면 false 리턴
	 * */

	@Override
	public boolean insertReserve(ReserveInfo info) {
		boolean result = false;
		// 완성하시오
		String reserverName = info.getReserverName();
		String reserverPhone = info.getReserverPhone();
		int roomNum = info.getRoomNum();
		String checkIn = info.getCheckIn();
		String checkOut = info.getCheckOut();
		int meaningDay = this.meanDay(checkOut, checkIn);
		int adultCount = info.getAdultCount();
		int childCount = info.getChildCount();
		int adultBreakfast = info.getAdultBreakfast();
		int childBreakfast = info.getChildBreakfast();
		int totalPrice = 
				(this.roomPrice(roomNum)*meaningDay) + (adultBreakfast * ADULTMEALPRICE) + (childBreakfast * CHILDMEALPRICE); 
		
		
		Connection con = ConnectionManager.getConnection();
		
		if (meaningDay <= 0) {
			System.out.println("날짜오류");
		} else {
			try {
				PreparedStatement ps = con.prepareStatement("INSERT INTO RESERVEINFO VALUES (RESERVEINFO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, reserverName);
				ps.setString(2, reserverPhone);
				ps.setInt(3, roomNum);
				ps.setString(4, checkIn);
				ps.setString(5, checkOut);
				ps.setInt(6, meaningDay);
				ps.setInt(7, adultCount);
				ps.setInt(8, childCount);
				ps.setInt(9, adultBreakfast);
				ps.setInt(10, childBreakfast);
				ps.setInt(11, totalPrice);
				int resultNum = ps.executeUpdate();
				if (!(resultNum == 0)) {
					result = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(con);
			}
		}
		
		return result;
	}

	/**
	 * 객실 번호를 이용해 객실 1박 이용료를 조회한다.
	 * @param roomNum : 가격을 조회하고자 하는 객실의 번호
	 * @return 객실 가격
	 */
	private int roomPrice(int roomNum) {
		int price = 0;
		ResultSet rs = null;
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT PRICE FROM ROOM WHERE ROOMNUM = ?");
			ps.setInt(1, roomNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				price = rs.getInt("PRICE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		
		return price;
	}

	/**
	 * 체크인 날짜와 체크아웃한 날짜를 이용하여 총 숙박일을 계산한다.
	 * @param checkOut
	 * @param checkIn
	 * @return checkOut - checkIn 한 날수 계산
	 */

	private int meanDay(String checkOut, String checkIn) {
		int result = 0;
		// 완성하시오
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT ((TO_DATE(?, 'YYYY/MM/DD') - TO_DATE(?, 'YYYY/MM/DD')))mene FROM DUAL");
			ps.setString(1, checkOut);
			ps.setString(2, checkIn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return result;
	}

	/**
	 * 등록된 예약정보  객체를 삭제한다.
	 * @param 예약자의 이름, 전화번호
	 * @return 예약 정보의 삭제 여부 리턴, 삭제 성공시 true, 삭제를 하지 못할 경우 false를 리턴
	 * */
	public boolean deleteReserve(String reserverName, String reserverPhone) {
		boolean result = false;

		// 완성하시오
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("DELETE FROM RESERVEINFO WHERE RESERVERNAME = ? AND RESERVERPHONE = ?");
			ps.setString(1, reserverName);
			ps.setString(2, reserverPhone);
			
			int resultNum = ps.executeUpdate();
			if (resultNum != 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return result;
	}

	/**
	 * 예약 정보를 수정한다..
	 * @param 수정할 예약 정보
	 * @return 예약 정보의 삭제 여부 리턴, 삭제 성공시 true, 삭제를 하지 못할 경우 false를 리턴
	 * */
	
	@Override
	public boolean updateReserve(ReserveInfo info) {
		boolean result = false;
		// 완성하시오
		String reserverName = info.getReserverName();
		String reserverPhone = info.getReserverPhone();
		int roomNum = info.getRoomNum();
		String checkIn = info.getCheckIn();
		String checkOut = info.getCheckOut();
		int meaningDay = this.meanDay(checkOut, checkIn);
		int adultCount = info.getAdultCount();
		int childCount = info.getChildCount();
		int adultBreakfast = info.getAdultBreakfast();
		int childBreakfast = info.getChildBreakfast();
		int totalPrice = 
				(this.roomPrice(roomNum)*meaningDay) + (adultBreakfast * ADULTMEALPRICE) + (childBreakfast * CHILDMEALPRICE); 
		
		Connection con = ConnectionManager.getConnection();
		System.out.println("123");
		
		try {
			PreparedStatement ps = con.prepareStatement
					("UPDATE RESERVEINFO "
							+ "SET ROOMNUM = ?, CHECKIN = ? , CHECKOUT = ?, MEANINGDAY = ?, ADULTCOUNT = ?, CHILDCOUNT = ?, "
							+ "ADULTBREAKFAST = ?, CHILDBREAKFAST = ?, TOTALPRICE = ?"
							+ "WHERE RESERVERNAME = ? AND RESERVERPHONE = ?");
			
			ps.setInt(1, roomNum);
			ps.setString(2, checkIn);
			ps.setString(3, checkOut);
			ps.setInt(4, meaningDay);
			ps.setInt(5, adultCount);
			ps.setInt(6, childCount);
			ps.setInt(7, adultBreakfast);
			ps.setInt(8, childBreakfast);
			ps.setInt(9, totalPrice);
			ps.setString(10, reserverName);
			ps.setString(11, reserverPhone);
			
			int resultNum = ps.executeUpdate();
			System.out.println("345");
			System.out.println(resultNum);
			if (resultNum != 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		
		return result;
	}



}