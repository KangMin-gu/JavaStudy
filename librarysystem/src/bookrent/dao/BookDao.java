package bookrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// 도서추가갈매기~
		// 도서삭제

	public boolean bkdelete() {
		return false;
	}// 도서삭제갈매기~
		// 도서수정

	public boolean bkupdate() {
		return false;
	}// 도서수정갈매기~
		// 도서검색

	public List<BookDto> bksearch() {
		List<BookDto> BD = new ArrayList<BookDto>();
		return BD;
	}// 도서검색갈매기~

}
