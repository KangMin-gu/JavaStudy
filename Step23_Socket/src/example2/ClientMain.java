package example2;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
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
		//Scanner 객체를 이용해서 서버로 전송할 문자열을 입력 받는다.
		Scanner scan=new Scanner(System.in);
		System.out.print("서버로 전송할 메세지 입력:");
		String msg = scan.next();
		
		//필요한 객체를 담을 변수 만들기
		Socket socket=null;
		OutputStream os=null;
		OutputStreamWriter osw=null;
		BufferedWriter bw=null;
		try{
			/*
			 * new Socket("ip주소", port 번호)
			 * 
			 * 1. 객체를 생성하는 시점에 연결 요청이되고 
			 * 2. 객체의 참조값이 리턴되면 Socket 연결이 성공한것이다. 
			 */
			socket=new Socket("192.168.0.10", 5000);
			System.out.println("Socket 연결 성공!");
			//Socket 을 이용해서 출력할수있는 스트림 객체 얻어오기 
			os = socket.getOutputStream();
			osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
			
			bw.write(msg); //문자열을 출력
			bw.newLine();  //개행기호 출력
			bw.flush();    //방출 ( 밀어내기 )
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(os!=null)os.close();
				if(osw!=null)osw.close();
				if(bw!=null)bw.close();
				if(socket!=null)socket.close();
			}catch(Exception e){}
		}
		System.out.println("Client main() 메소드가 종료 됩니다.");
	}	
}



