package example3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

/*
 *  파일을 다운로드할 스레드 
 */
public class FileDownThread extends Thread{
	//필드
	private Socket socket;
	
	//생성자
	public FileDownThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		//필요한 객체의 참조값을 담을 변수 만들기
		InputStream is=null;
		FileOutputStream fos=null;
		try{
			//파일을 전송한 클라이언트의 ip 주소 
			String ip=socket.getInetAddress().getHostAddress();
			//파일을 저장할 경로와 파일명 정하기
			String path="c:/myFolder/"+ip+"image.jpg";
			//필요한 객체의 참조값 얻어오기
			is=socket.getInputStream();
			fos=new FileOutputStream(path);
			//byte 데이터를 담을 배열
			byte[] buffer=new byte[1024];
			//반복문 돌면서 전달된 데이터를 읽어들인다.
			while(true){
				int readedByte=is.read(buffer);
				if(readedByte==-1)break;
				//읽어들인 만큼 파일에 출력하기
				fos.write(buffer, 0, readedByte);
				fos.flush();
			}
			System.out.println(ip+" 에서 전송한 파일 저장성공");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(is!=null)is.close();
				if(fos!=null)fos.close();
				if(socket!=null)socket.close();
			}catch(Exception e){}
		}
		System.out.println("새로운 스레드가 종료 됩니다.");		
	}
}









