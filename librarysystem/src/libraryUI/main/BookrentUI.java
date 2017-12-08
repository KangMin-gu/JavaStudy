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
	public String gname;
	public String mname;
	public String gjumin;
	public String mjumin;

	public BookrentUI() {
		dao = BookDao.getInstance();
		managerview();
		//login();
	}

	public void login() {
		sc = new Scanner(System.in);

		System.out.println("-----------선택하세요!!--------------");
		System.out.println("       1.일반회원  2. 관리자                 ");
		System.out.println("------------------------------------");

		num = sc.nextInt();
		if (num == 1) {
			System.out.println("이름을 입력하세요");
			gname = sc.next();
			System.out.println("주민번호를 입력하세요");
			gjumin = sc.next();

			checkgenerallogin();

		} else if (num == 2) {
			System.out.println("이름을 입력하세요");
			mname = sc.next();
			System.out.println("주민번호를 입력하세요");
			mjumin = sc.next();

			checkmanagerlogin();

		} else {
			System.out.println("아이디 또는 비밀번호를 확인해주세요.");
			login();
		}
	}

	// 관리자화면
	public void managerview() {
		sc = new Scanner(System.in);
		
		System.out.println("------관리자님 번호를 입력해주세요.-------------------");
		System.out.println("1.책등록  2. 책수정  3.책 삭제 4. 보유 도서 전체 검색  5. isbn 검색  6. 일반회원검색 ");
		System.out.println("--------------------------------------------------");
		
		num = sc.nextInt();

		if (num == 1) {
			entry();
		} else if (num == 2) {
			set();
		} else if (num == 3) {
			del();
		} else if (num == 4) {
			System.out.println("=============================================================");
			bookallfind();
			System.out.println("=============================================================");
			managerview();
		} else if (num == 5) {
			System.out.println("=============================================================");
			bookisbnfind();
			System.out.println("=============================================================");
			managerview();
		} else if (num == 6) {
			genericfind();
		} else if (num == 7) {
			signUp();
		} else {
			managerview();
		}

	}

	// 회원화면
	public void generalview() {

		System.out.println("-----회원님 번호를 입력해주세요.-----------------");
		System.out.println("1. 도서 검색  2. 대여하기  3. 반납하기  4. 회원탈퇴 ");
		System.out.println("---------------------------------------------");

		num = sc.nextInt();

		if (num == 1) {
			bookisbnfind();
		} else if (num == 2) {
			rent();
		} else if (num == 3) {
			derent();
		} else if (num == 4) {
			signOut();
		} else {
			generalview();
		}

	}

	// 로그인 매칭 메소드
	public void checkmanagerlogin() {
		// chekmethod
	}

	public void checkgenerallogin() {
		// checkmethod
	}

	// manager menu
	// ------------------------------------------------------------------
	// 도서등록정보입력
	public void entry() {
		System.out.println("장르: ");
		genre = sc.next();
		System.out.println("책제목: ");
		bkname = sc.next();
		System.out.println("저자: ");
		writer = sc.next();
		System.out.println("출판사: ");
		publisher = sc.next();
		System.out.println("ISBN: ");
		isbn = sc.nextInt();
		System.out.println("소비자가격: ");
		price = sc.nextInt();
		rentalFee = (int) (price * 0.1);
		BookDto dto = new BookDto(isbn, genre, bkname, writer, publisher, price, rentalFee);
		dao.bkinsert(dto);
		managerview();
	}

	public void set() {
		
		System.out.println("수정하실 도서의 ISBN을 입력하세요 : ");
		int isbn = sc.nextInt();
		System.out.println("장르: ");
		String genre = sc.next();
		System.out.println("책제목: ");
		String bkname = sc.next();
		System.out.println("저자: ");
		String writer = sc.next();
		System.out.println("출판사: ");
		String publisher = sc.next();
		System.out.println("소비자가격: ");
		int price = sc.nextInt();
		rentalFee = (int) (price * 0.1);
		BookDto BD = new BookDto (isbn, genre, bkname, writer, publisher, price, rentalFee);
		dao.getInstance();		
		dao.bkupdate(BD);	
		managerview();
	}

	public void del() {
		System.out.println("삭제하실 도서의 ISBN을 입력하세요 :");
		int isbn = sc.nextInt();
		dao.getInstance();
		dao.bkdelete(isbn);
		managerview();
		
	}

	public void bookallfind() {
		dao.getInstance();
		dao.bkAllsearch();
	}
	
	public void bookisbnfind() {
		// isbn으로 목록찾기
		System.out.println("검색하실 도서의 ISBN을 입력하세요 :");
		int isbn = sc.nextInt();
		dao.getInstance();
		dao.getbook(isbn);
		
	}

	public void genericfind() {
		// 일반회원찾기
	}

	public void signUp() {
		// 회원가입시키기
	}

	// generic menu
	// ----------------------------------------------------------------------
	public void rent() {
		// 대여하기
	}

	public void derent() {
		// 반납하기
	}

	public void signOut() {
		// 회원탈퇴
	}

	// 메인메소드 실행
	public static void main(String[] args) {
		new BookrentUI();
	
	}
}
