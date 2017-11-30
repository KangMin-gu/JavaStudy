package manager;
import java.util.ArrayList;

import vo.ReserveInfo;
import vo.Room;

public interface ReservationManager {
	/**
	 * 예약 가능한 모든 객실 목록을 반환한다.
	 * @return 예약 가능한 모든 객실 목록을 반환한다. 이미 예약이 되었는 경우는 목록에 포함되지 않아야 한다.
	 * */
	public ArrayList<Room> getRoomList();
	
	/**
	 * 객실 예약 정보를 저장한다. 
	 * @param 클라이언트가 요청한 객체 예약정보
	 * @return 등록 성공시 true를, 실패 시 false를 반환한다.
	 * */
	public boolean insertReserve(ReserveInfo info);

	/**
	 * 예약해 놓은 객실의 정보를 리스트를 조회한다.
	 * @param 예약자의 이름과 전화번호
	 * @return 예약된 정보가 있을 경우 예약 정보를, 예약 정보가 없을 경우 null을 반환한다.
	 * */
	public ReserveInfo confirmReserve(String reserverName, String reserverPhone);

	/**
	 * 등록된 예약정보  객체를 삭제한다.
	 * @param 예약자의 이름, 전화번호
	 * @return 예약 정보의 삭제 여부 리턴, 삭제 성공시 true, 삭제를 하지 못할 경우 false를 리턴
	 * */
	public boolean deleteReserve(String reserverName, String reserverPhone);
	
	/**
	 * 예약 정보를 수정한다..
	 * @param 수정할 예약 정보
	 * @return 예약 정보의 삭제 여부 리턴, 삭제 성공시 true, 삭제를 하지 못할 경우 false를 리턴
	 * */
	public boolean updateReserve(ReserveInfo info);
}
