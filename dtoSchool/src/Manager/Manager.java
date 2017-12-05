package Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import vo.Human;
import vo.Trainee;

public class Manager {

	ArrayList<Human> alist;

	public Manager() {
		alist = new ArrayList<>();

	}

	public void join(Human human) {
		alist.add(human);
		System.out.println("등록되었습니다.");
		return;
	}

	public void show() {
		for (int i = 0; i < alist.size(); i++) {
			alist.get(i).showInfo();
		}
		return;
	}

	public void findHuman(int juminNum) {
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).getJumin() == juminNum) {
				System.out.println("해당 인원이 다음과 같이 등록되어있습니다.");
				alist.get(i).showInfo();

			} else {
				System.out.println("해당 인원을 검색할 수 없습니다.");
				System.out.println("주민등록 번호가 잘못 입력 되었거나 등록되어 있지 않습니다.");
			}
		}
		return;
	}

	public void delHuman(int juminNum) {
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).getJumin() == juminNum) {
				System.out.println("해당 인원을 삭제하겠습니다.");
				alist.remove(i);
				System.out.println("해당 인원이 삭제되었습니다.");
			}
		}
		return;
	}

	public void settHuman(int cjumin) {
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).getJumin() == cjumin) {
				System.out.println("등록되어있는 학생입니다.");
				System.out.println("수정할 학번을 입력해주세요.");
				Scanner sc = new Scanner(System.in);
				String setStdn = sc.next();
				Trainee h = (Trainee) alist.get(i);
				h.setStdNo(setStdn);
				System.out.println("학번이 수정되었습니다.");
				for (Human human : alist) {
					human.showInfo();
				}
			}
		}
	}

	public void save() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
		
			oos.writeObject(alist);
			
			oos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void read() {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
				try {
					alist = (ArrayList<Human>) ois.readObject();
					show();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
					
					
		}
	
	
}
