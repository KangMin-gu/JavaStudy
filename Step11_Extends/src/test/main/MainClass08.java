package test.main;

import test.auto.Car;
import test.auto.Sedan;

public class MainClass08 {
	public static void main(String[] args) {
		Sedan car1=new Sedan();
		// 오버라이딩 된 메소드 호출해 보기 
		car1.drive();
		// Sedan 객체를 useCar() 메소드의 인자로 전달해 보기
		useCar(car1);
	}
	
	public static void useCar(Car car) {
		car.startEngine();
		car.drive();
	}
}






