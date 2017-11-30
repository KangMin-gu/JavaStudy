package example1;

import java.net.Socket;
/*
 *  [ Socket 클라이언트 프로그램 작성순서 ]
 *  
 *  1. Socket 객체 생성: 생성됨과 동시에 서버에 소켓 접속을 시도함
 *     - 접속할 서버의 ip 주소와  port 번호가 필요하다
 *  2. Socket 객체를 이용해서 서버와 통신하기
 *  3. 필요한 작업을 완료한후 Socket 객체 닫아주기
 */
public class ClientMain {
	public static void main(String[] args) {
		Socket socket=null;
		try {
			//new Socket("접속ip", 포트번호)
			socket=new Socket("192.168.0.10", 5000);
			System.out.println("접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null)socket.close();
			}catch(Exception e) {}
		}
		System.out.println("Client main() 메소드가 종료 됩니다.");
	}
}



