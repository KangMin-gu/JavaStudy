package test.main;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type 을 담을수 있는 방 3개짜리 배열객체를 
		//   생성해서 참조값를 cars 라는 변수에 담아 보세요.
		Car[] cars=new Car[3];
		//2. Car 객체를 생성하되 생성자의 인자로 
		//   "소나타", "아반떼", "프라이드" 를 각각 전달해서 
		//   객체를 생성해서 cars 배열에 0번방 1번방 2번방에 
		//   각각 담아 보세요.
		cars[0] = new Car("소나타");
		cars[1] = new Car("아반떼");
		cars[2] = new Car("프라이드");
		
		//3. 배열에 저장된 Car 객체의 참조값을 이용해서 
		//   drive() 메소드를 각각 호출해 보세요.
		cars[0].drive();
		cars[1].drive();
		cars[2].drive();
		
		Car[] cars2={new Car("A"), new Car("B"), new Car("C")};
		cars2[0].drive();
		cars2[1].drive();
		cars2[2].drive();
	
	}
}















