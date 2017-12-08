package test.dto;

public class FriendsDto {
	private int num;
	private String name;
	private String phone;
	private String date;

	public FriendsDto() {

	}

	public FriendsDto(int num, String name, String phone, String date) {
		this.num=num;
		this.name=name;
		this.phone=phone;
		this.date=date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
