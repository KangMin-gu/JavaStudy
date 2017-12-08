package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.FriendsDto;
import test.dto.MemberDto;
import test.util.DBConnect;

public class FriendsDao {
	private static FriendsDao dao;

	private FriendsDao() {

	}

	public static FriendsDao getInstance() {
		if (dao == null) {
			dao = new FriendsDao();
		}
		return dao;
	}

	public void insert(FriendsDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = new DBConnect().getConn();
		String sql = "insert into friends values (friends_seq.nextval, ? , ? ,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
				if (conn != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}// 정보넣기

	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = new DBConnect().getConn();
		String sql = "delete from friends where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void update(FriendsDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 작업의 성공여부를 담을 변수
		conn = new DBConnect().getConn();
		String sql = "update friends set name=?, phone=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, dto.getNum());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	public List<FriendsDto> getList() {
		List<FriendsDto> alist = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "Select * From friends";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String date = rs.getString("regdate");
				FriendsDto friends = new FriendsDto(num, name, phone, date);
				alist.add(friends);
			}
			for (FriendsDto friends : alist) {
				System.out.println(friends.getNum() + "/" + friends.getName() + "/" + friends.getPhone());
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
