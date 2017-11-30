package vo;

public class Human {

	private String name;
	private int age;
	private int jumin;
	
	public Human() {
		
	};	
	
	public Human(String name, int age, int jumin) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJumin() {
		return jumin;
	}

	public void setJumin(int jumin) {
		this.jumin = jumin;
	}

	public void showInfo() {
		System.out.print("이름:" + name + ", 나이:" + age + ", 주민:" + jumin);
	}

}
