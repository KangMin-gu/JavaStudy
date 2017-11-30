package vo;

public class Trainee extends Human {
	private String stdNo; // 연수생 학번

	public Trainee(String name, int age, int jumin, String stdNo) {
		super(name, age, jumin);
		this.stdNo = stdNo;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public void showInfo() {
		super.showInfo();
		System.out.printf(", 학번: %s%n", stdNo);
	}

}
