package memberDto;

public class MemberDto {
	private String name;
	private String jumin;
	private String phone;
	private String addr;

	public MemberDto() {
	}

	public MemberDto(String name, String jumin, String phone, String addr) {
		this.name = name;
		this.jumin = jumin;
		this.phone = phone;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
