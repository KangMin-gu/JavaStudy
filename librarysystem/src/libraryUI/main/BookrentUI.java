package libraryUI.main;

import java.util.Scanner;

import bookrent.dao.BookDao;
import bookrent.dto.BookDto;

// orcle DB manager id  admin / admin
public class BookrentUI {
	public Scanner sc;
	public int num; // scanner 번호.
	public String genre;
	public String bkname;
	public String writer;
	public String publisher;
	public int isbn;
	public int price;
	public int rentalFee;
	public BookDao dao;


	public BookrentUI() {
		dao = BookDao.getInstance();
		view();
	}

	public void view() {

		System.out.println("-----------번호를 입력해주세요.--------");
		System.out.println("1.책등록  2. 책수정  3.책 삭제 4. 책 검색 ");
		System.out.println("------------------------------------");

		sc = new Scanner(System.in);
		num = sc.nextInt();

		if (num == 1) {
			entry();
		}else if(num==2) {
			
		}else if(num==3) {
			
		}else if(num==4) {
			
		}else {
			
		}
	}

	public void entry() {
		System.out.println("장르: ");
		genre=sc.next();
		
		System.out.println("책제목: ");
		bkname=sc.next();
		
		System.out.println("저자: ");
		writer=sc.next();
		
		System.out.println("출판사: ");
		publisher=sc.next();
		
		System.out.println("ISBN: ");
		isbn=sc.nextInt();
		
		System.out.println("소비자가격: ");
		price=sc.nextInt();
		
		rentalFee = (int) (price * 0.1) ;
		
		BookDto dto = new BookDto(isbn, genre, bkname, writer, publisher, price, rentalFee);
		dao.bkinsert(dto);
	}

	public static void main(String[] args) {
		new BookrentUI();		
	}
}


