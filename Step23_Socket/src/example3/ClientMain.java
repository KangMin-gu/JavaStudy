package example3;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		//필요한 객체를 담을 변수 만들기
		Socket socket=null;
		OutputStream os=null;
		FileInputStream fis=null;
		try{
			/*
			 * new Socket("ip주소", port 번호)
			 * 
			 * 1. 객체를 생성하는 시점에 연결 요청이되고 
			 * 2. 객체의 참조값이 리턴되면 Socket 연결이 성공한것이다. 
			 */
			socket=new Socket("192.168.0.10", 5000);
			System.out.println("Socket 연결 성공!");
			fis=new FileInputStream("c:/myFolder/myImage.jpg");
			os=socket.getOutputStream();
			//byte 데이터를 읽어들일 배열
			byte[] buffer=new byte[1024];
			//반복문 돌면서 파일에서 읽어들이고 동시에 출력하기
			while(true){
				//FileInputStream 객체를 이용해서 byte 데이터를 읽어들인다. 
				int readedByte=fis.read(buffer);
				//더이상 읽을 데이터가 없다면 반복문 빠져 나오기
				if(readedByte==-1)break;
				//읽어온만큼 OutputStream 객체를 통해서 출력한다.
				os.write(buffer, 0, readedByte);
				os.flush();//방출
			}
			System.out.println("파일 전송 성공!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(os!=null)os.close();
				if(fis!=null)fis.close();
				if(socket!=null)socket.close();
			}catch(Exception e){}
		}
		System.out.println("Client main() 메소드가 종료 됩니다.");
	}
}
