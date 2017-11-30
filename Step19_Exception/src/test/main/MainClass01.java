package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		try {
			System.out.print("젯수 입력(정수):");
			int num1=scan.nextInt();
			System.out.print("피젯수 입력(정수):");
			int num2=scan.nextInt();
			
			//num2 를 num1 으로 나눈 몫 
			int mog=num2/num1;
			//num2 를 num1 으로 나눈 나머지
			int na=num2%num1;
			
			System.out.println(num2+"를"+num1+"으로 나눈몫:"+mog);
			System.out.println
				(num2+"를"+num1+"으로 나눈 나머지:"+na);
			
		}catch(Exception e) {
			System.out.println("Exception 발생!");
			System.out.println("예외 정보:"+e.getMessage());
			e.printStackTrace();
		}
		
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}









