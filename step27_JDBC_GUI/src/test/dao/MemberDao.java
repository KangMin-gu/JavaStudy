package test.dao;

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
public class MemberDao {
	// 1. 자신의 참조값을 담을 private static 필드 만들기
	private static MemberDao dao;

	// 2. 외부에서 객체 생성할수 없도록 생성자의 접근지정자를
	// private 로 지정
	private MemberDao() {
	}

	// 3. 자신의 참조값을 리턴해주는 static 멤버 메소드 만들기
	public static MemberDao getInstance() {
		if (dao == null) {
			dao = new MemberDao();
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
			String sql = "INSERT INTO member  (num,name,addr)"
							+ "VALUES (member_seq.nextval,?,?) oder by num desc";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
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
	// Vector은 ArryaList보다 기능추가로 무거운 객체 기능은 거의같다.메소드도 똑같이 사용한다.
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
			String sql = "Select * From member";
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
		return alist;
	}

}