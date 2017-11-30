package example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
 *  [ Socket 서버 프로그램 작성 순서]
 *  
 *  1. ServerSocket 객체를 생성한다. (port 번호 필요)
 *  2. 클라이언트의 접속을 기다리고 있다가 접속해 오면 이를 받아들인다.
 *  3. 반환된 Socket 객체는 클라이언트와 통신을 하고 ServerSocket 객체는
 *     다시 다른 클라이언트의 접속을 기다린다.
 *  4. 클라이언트와 접속을 종료 하려면 Socket 객체를 닫아준다. 
 */
public class ServerMain {
	public static void main(String[] args) {
		//필요한 객체를 저장할 변수 만들기
		ServerSocket serverSocket=null;
		Socket socket=null;	
		try {
			//5000번 port 에서 클라이언트의 소켓 접속을
			//기다릴 ServerSocket 객체 
			serverSocket=new ServerSocket(5000);
			while(true) {
				System.out.println("접속 대기중...");
				socket=serverSocket.accept();
				//접속된 클라이언트의 ip 주소
				String clientIp=socket.getInetAddress()
						.getHostAddress();
				System.out.println("clientIp:"+clientIp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket!=null)serverSocket.close();
				if(socket!=null)socket.close();
			}catch(Exception e) {}
		}
	}
}















