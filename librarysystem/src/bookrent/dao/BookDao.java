package bookrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bookrent.dto.BookDto;
import util.DBConnect;

//oracle DB 접속 계정 admin /admin
/*
 * 도서 대여 기능
 * 도서추가
 * 도서삭제
 * 도서검색
 * 도서수정
 * 도서대여
 * 도서반납
 * 	
 */
public class BookDao {

	private static BookDao dao;

	private BookDao() {
	}

	public static BookDao getInstance() {
		if (dao == null) {
			dao = new BookDao();
		}
		return dao;
	}

	// -------------------도서 리스트 기능 -------------------------------
	// 도서추가
	public boolean bkinsert(BookDto BD) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		// DB와 연결할 터널불러오기
		try {
			conn = new DBConnect().getConn();
			String sql = "insert into booklist (isbn, genre, bkname, writer, publisher, price, rentalfee)"
					+ "values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, BD.getIsbn());
			pstmt.setString(2, BD.getGenre());
			pstmt.setString(3, BD.getBkname());
			pstmt.setString(4, BD.getWriter());
			pstmt.setString(5, BD.getPublisher());
			pstmt.setInt(6, BD.getPrice());
			pstmt.setInt(7, BD.getRentalFee());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				isSuccess = true;

				System.out.println("도서가 등록 되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// 도서추가갈매기~

	// 도서삭제
	public boolean bkdelete(int isbn) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			String sql = "delete from booklist where isbn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, isbn);
			int flag = pstmt.executeUpdate();
			if (flag > 0) {
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
	}// 도서삭제갈매기~

	// 도서수정
	public boolean bkupdate(BookDto BD) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "update booklist set genre=?, bkname=?, writer=?, publisher=?, price=?, rentalFee=? where isbn=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setString(1, BD.getGenre());
			pstmt.setString(2, BD.getBkname());
			pstmt.setString(3, BD.getWriter());
			pstmt.setString(4, BD.getPublisher());
			pstmt.setInt(5, BD.getPrice());
			pstmt.setInt(6, BD.getRentalFee());
			pstmt.setInt(7, BD.getIsbn());
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
	}// 도서수정갈매기~

	// 도서 전체 검색
	public List<BookDto> bkAllsearch() {
		List<BookDto> BD = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 작업의 성공여부를 담을 변수
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "Select * From booklist";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int isbn = rs.getInt("isbn");
				String genre = rs.getString("genre");
				String bkname = rs.getString("bkname");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				int rentalfee = rs.getInt("rentalFee");
				BookDto BD1 = new BookDto(isbn, genre, bkname, writer, publisher, price, rentalfee);
				BD.add(BD1);
			}
			for (BookDto BookDto : BD) {
				System.out.println("장르:" + BookDto.getGenre() +"/" + "책 제목 :" + BookDto.getBkname() +"/" + "출판사 :"
						+ BookDto.getPublisher() +"/" + "대여료 :" + BookDto.getRentalFee() + "/"+"ISBN :"+BookDto.getIsbn());
			}
			int flag = pstmt.executeUpdate();
			if (flag > 0) {
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

	// isbn으로 검색
	public BookDto getbook(int isbn) {
		List<BookDto> BD = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isSuccess = false;
		try {
			conn = new DBConnect().getConn();
			String sql = "Select genre, bkname, writer, publisher, price, rentalFee From booklist where isbn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, isbn);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String genre = rs.getString("genre");
				String bkname = rs.getString("bkname");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				int rentalfee = rs.getInt("rentalFee");
				BookDto BD1 = new BookDto(isbn, genre, bkname, writer, publisher, price, rentalfee);
				BD.add(BD1);
			}
			for (BookDto BookDto : BD) {
				System.out.println("장르:" + BookDto.getGenre() +"/" + "책 제목 :" + BookDto.getBkname() +"/" + "출판사 :"
						+ BookDto.getPublisher() +"/" + "대여료 :" + BookDto.getRentalFee() + "/"+"ISBN :"+BookDto.getIsbn());
			}
			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				isSuccess = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		} // try

		return null;
	}
}
