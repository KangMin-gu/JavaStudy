package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 *   번호: 20
		 *   이름: 누구게
		 *   주소: 어디게
		 *   
		 *   위의 정보를 MemberDto 객체에 담은 다음 
		 *   MemberDto 객체가 담긴 변수를 참조해서 
		 *   해당 정보를 DB 에 저장해 보세요.
		 */
		
		//MemberDto dto=new MemberDto(20, "누구게", "어디게");
		MemberDto dto=new MemberDto();
		dto.setNum(20);
		dto.setName("누구게");
		dto.setAddr("어디게");
		
		//Connection 객체의 참조값 얻어오기 
		Connection conn=new DBConnect().getConn();
		//필요한 객체를 담을 변수 만들기 
		PreparedStatement pstmt=null;
		try{
			//실행할 SQL 문의 뼈대 구성하기
			String sql="INSERT INTO member (num,name,addr) "
					+ "VALUES(?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddr());
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}//try
	}
}










