package bookrent.dto;

public class BookDto {
	private String genre; // 장르
	private String bkname; // 책제목
	private String writer; // 저자
	private String publisher; // 출판사
	private int isbn; // isbn 중복불가 primary key
	private int price; // 가격
	private int rentalFee; // 대여료

	public BookDto() {

	}

	public BookDto(int isbn, String genre, String bkname, String writer, String publisher, int price, int rentalFee) {
		super();
		this.isbn = isbn;
		this.genre = genre;
		this.bkname = bkname;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.rentalFee = rentalFee;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBkname() {
		return bkname;
	}

	public void setBkname(String bkname) {
		this.bkname = bkname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(int rentalFee) {
		this.rentalFee = rentalFee;
	}

}
