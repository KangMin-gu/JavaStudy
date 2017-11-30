package UI;

import java.util.Scanner;

import Manager.Manager;
import vo.Human;
import vo.Professor;
import vo.Trainee;

public class MainUi {

	public Scanner sc;
	public int num;
	public String name;
	public int age;
	public int jumin;
	public Manager mg;
	public String setStdn;
	public int cjumin;


	public MainUi() {
		mg = new Manager();
		view();
	}

	// 메인메뉴
	public void view() {
		System.out.println("--------------------------------");
		System.out.println("에이콘 학원");
		System.out.println("1.등록   2.삭제  3.검색  4.수정 5.전체보기");
		System.out.println("--------------------------------");

		sc = new Scanner(System.in); // 스캐너 객체 생성
		System.out.println("번호 입력해주세요!!!");
		num = sc.nextInt();

		if (num == 1) {
			input();
		} else if (num == 2) {
			delete();
		} else if (num == 3) {
			search();
		} else if (num == 4) {
			setStdN();
		} else if (num == 5) {
			showInfo();
		} else {
			System.out.println("잘못입력했어요");
			view();
		}
	}

	// 등록메뉴
	public void input() {
		System.out.println("1.학생    2.교수  0.이전화면");
		num = sc.nextInt();

		System.out.print("이름: ");
		name = sc.next();
		System.out.print("나이: ");
		age = sc.nextInt();
		System.out.print("주민번호: ");
		jumin = sc.nextInt();

		if (num == 1) {
			System.out.print("학번: ");
			String stdNo = sc.next();
			Trainee t = new Trainee(name, age, jumin, stdNo);
			mg.join(t);
		} else if (num == 2) {
			System.out.print("전공: ");
			String major = sc.next();
			Professor p = new Professor(name, age, jumin, major);
			mg.join(p);
		} else if (num == 0) {
			view();
		} else {
			System.out.println("정확히 입력해주세요");
		}
		view();
	}

	// 삭제메뉴
	public void search() {
		System.out.println("주민번호입력");
		int juminNum = sc.nextInt();
		mg.findHuman(juminNum);
		view();
	}
	
	public void delete() {
		System.out.println("주민번호입력");
		int juminNum = sc.nextInt();
		mg.delHuman(juminNum);
		view();
	}
	
	public void setStdN() {
		System.out.println("주민번호입력");
		int cjumin = sc.nextInt();
		mg.settHuman(cjumin);
		view();
	}

	// 전체보기
	public void showInfo() {
		mg.show();
		view();
	}

	// 시작 메인메소드
	public static void main(String[] args) {
		MainUi ui = new MainUi();
	}
}
