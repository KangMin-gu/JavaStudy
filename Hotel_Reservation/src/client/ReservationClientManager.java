package client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import manager.ReservationManager;
import vo.ReserveInfo;
import vo.Room;

public class ReservationClientManager implements ReservationManager {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Room> roomList;

	public ReservationClientManager(){
		try{
			socket = new Socket("127.0.0.1", 7878);
			System.out.println("Server 접속성공!!!");
			is = socket.getInputStream();			
			os = socket.getOutputStream();	
			oos = new ObjectOutputStream(os);
			ois = new ObjectInputStream(is);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Room> getRoomList() {
		ArrayList<Room> roomList=null;
		// 완성하시오
		Object [] obj = {"roomlist", null, null};
		roomList = (ArrayList<Room>) this.sendRequest(obj);
		return roomList;
	}

	@Override
	public boolean insertReserve(ReserveInfo info) {
		boolean result = false;
		// 완성하시오
		Object [] obj = {"insert",  info, null};
		result = (boolean) this.sendRequest(obj);
		return result;
	}

	@Override
	public ReserveInfo confirmReserve(String reserverName, String reserverPhone) {
		ReserveInfo info = null;
		// 완성하시오
		Object [] obj = {"confirm",  reserverName, reserverPhone};
		info = (ReserveInfo) this.sendRequest(obj);
		return info;
	}

	@Override
	public boolean deleteReserve(String reserverName, String reserverPhone) {
		boolean result = false;
		// 완성하시오.
		Object [] obj = {"delete",  reserverName, reserverPhone};
		result = (boolean) this.sendRequest(obj);
		return result;
	}

	@Override
	public boolean updateReserve(ReserveInfo info) {
		boolean result = false;
		// 완성하시오
		Object [] obj = {"update",  info, null};
		result = (boolean) this.sendRequest(obj);
		return result;
	}


	public Object sendRequest(Object[] request){
		Object receive = null;
		// 완성하시오
		try {
			oos.writeObject(request);
			receive = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return receive;
	}
}
