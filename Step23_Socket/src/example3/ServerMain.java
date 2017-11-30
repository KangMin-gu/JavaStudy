package example3;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		//필요한 객체를 저장할 변수 만들기
		ServerSocket serverSocket=null;
		try{
			//5000 번 port 에서 클라이언트의 접속을 기다린다.
			serverSocket=new ServerSocket(5000);
			System.out.println("클라이언트의 Socket 연결 요청을 대기중...");
			while(true){
				//연결요청을 해오면 클라이언트와 연결된 Socket 객체의 참조값이 리턴된다.
				Socket socket=serverSocket.accept();
				
				//FileDownThread 객체를 생성하고 start() 메소드를 호출해서
				//새로운 스레드를 시작 시킨다. 
				new FileDownThread(socket).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(serverSocket!=null)serverSocket.close();
			}catch(Exception e){}
		}
		System.out.println("Server main() 메소드가 종료 됩니다. ");
	}
}
