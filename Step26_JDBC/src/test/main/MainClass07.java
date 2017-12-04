package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Dao => Date Access Object 의 약자
 *  
 *  -회원정보에 대해서 SELECT, INSERT, UPDATE, DELETE
 *   작업을 수행할 객체를 생성하기 위한 클래스 설계하기
 *   
 *   - Application 전역에서 MemberDao 객체는 오직 1개만 
 *    생성될수 있도록 설계한다.
 */
public class MainClass07 {
	// 1. 자신의 참조값을 담을 private static 필드 만들기
	private static MainClass07 dao;

	// 2. 외부에서 객체 생성할수 없도록 생성자의 접근지정자를
	// private 로 지정
	private MainClass07() {
	}

	// 3. 자신의 참조값을 리턴해주는 static 멤버 메소드 만들기
	public static MainClass07 getInstance() {
		if (dao == null) {
			dao = new MainClass07();
		}
		return dao;
	}

	// DB 에 회원 정보를 저장하는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "INSERT INTO member  num,name,addr)" + "VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddr());
			// sql 문 수행하고 추가된 row 의 갯수 얻어오기
			int flag = pstmt.executeUpdate();
			if (flag > 0) {// 작업 성공이면
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}

		return isSuccess;
	}

	// DB 에 회원 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "delete from member where num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setInt(1, num);
			// sql 문 수행하고 추가된 row 의 갯수 얻어오기
			int flag = pstmt.executeUpdate();
			if (flag > 0) {// 작업 성공이면
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return isSuccess;
	}

	// DB 에 회원 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "update member set name=?, addr=? where num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			// sql 문 수행하고 추가된 row 의 갯수 얻어오기
			int flag = pstmt.executeUpdate();
			if (flag > 0) {// 작업 성공이면
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return isSuccess;
	}

	// DB 에 회원 목록을 리턴해주는 메소드
	public List<MemberDto> getList() {
		List<MemberDto> alist = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "Select num, name, addr From member";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				MemberDto members = new MemberDto(num, name, addr);
				alist.add(members);
			}
			for (MemberDto memberDto : alist) {
				System.out.println(memberDto.getNum() + "/" + memberDto.getName() + "/" + memberDto.getAddr());
			}
			// sql 문 수행하고 추가된 row 의 갯수 얻어오기
			int flag = pstmt.executeUpdate();
			if (flag > 0) {// 작업 성공이면
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

}