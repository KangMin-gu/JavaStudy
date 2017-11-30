package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.ReserveInfo;
import vo.Room;


/**
 * SES 서버의 다중접속 환경을 구현하기 위한 스레드 클래스
 * SESServer에서 사용자의 접속이 이루어지면 SESServerThread 객체를 생성하여
 * run() 메서드에서 ObjectInputStream 와 ObjectOutputStream을 이용하여 클라이언트와 독립적인 통신을 수행한다.
 * */

public class ReservationThread implements Runnable {
	private ReservationServerManager manager = new ReservationServerManager();	
	
	private ObjectInputStream nois;
	private ObjectOutputStream noos;
	
	private boolean exit = false;

	public ReservationThread(ObjectInputStream nois, ObjectOutputStream noos) {
		this.nois =  nois;
		this.noos = noos;
	}

	@Override
	public void run() {
		while(!exit){	
			
			try{
				boolean result = false;
				Object[] oa= (Object[])nois.readObject();		
				String caseString = (String)oa[0];
				Object caseObject1 = oa[1];
				Object caseObject2 = oa[2];
				switch(caseString){
					case "roomlist":ArrayList<Room> roomList = manager.getRoomList();
									noos.writeObject(roomList);	
									break;
									
					case "insert":	result = manager.insertReserve((ReserveInfo)caseObject1);
									noos.writeObject(result);
									break;
									
					case "confirm":	ReserveInfo info = manager.confirmReserve((String)caseObject1, (String)caseObject2);
									noos.writeObject(info);
									break;
									
					case "delete":	result = manager.deleteReserve((String)caseObject1, (String)caseObject2);
									noos.writeObject(result);
									break;
									
					case "update":	result = manager.updateReserve((ReserveInfo)caseObject1);
									noos.writeObject(result);
									break;
		
				} //switch
			} catch(IOException ioe){
				exit = true;
				System.out.println(ioe.getMessage());
				
			} catch(ClassNotFoundException cce){
				exit = true;
				System.out.println(cce.getMessage());
				
			} //catch
		} //while
	}
}
