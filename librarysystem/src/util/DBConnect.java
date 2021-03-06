package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//맴버필드
	private Connection conn;
	
	//생성자에서 Connection 객체를 얻어와서 맴버필드에 저장되도록한다.
	public DBConnect(){
		try{
			//오라클 드라이버 로딩하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 oracle DB url 정보
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "admin", "admin");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//맴버필드에 저장된 Connection 객체의 참조값을 리턴해주는 메소드
	public Connection getConn(){
		return conn;
	}	
}
