package vo;

public class Professor extends Human {
	private String major; // 교수의 전공과목

	public Professor(String name, int age, int jumin, String major) {
		super(name, age, jumin);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void showInfo() {
		super.showInfo();
		System.out.printf(", 교수전공: %s%n", major);
	}

}
