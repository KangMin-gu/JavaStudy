package test.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass02 {
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
		}catch(InputMismatchException ime){
			//InputMismatchException type 의 예외가 발생하면 
			//실행되는 블럭 
			//ime.printStackTrace();
			System.out.println("숫자 형식으로 입력 하세요");
		}catch(ArithmeticException ie) {
			//ArithmethicException type 의 예외가 발생하면 
			//실행되는 블럭 
			//ie.printStackTrace();
			System.out.println("어떤수를 0으로 나눌수는 없어요");
		}catch(Exception e) {
			//위의 2가지 이외의 예외가 발생하면 실행되는 블럭 
			System.out.println("Exception 발생!");
			System.out.println("예외 정보:"+e.getMessage());
			e.printStackTrace();
		}finally {
			// 예외가 발생하던 안하던 반듯이 실행이 보장되는 블럭
			System.out.println("마무리 작업을 합니다.");
		}
		
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}









