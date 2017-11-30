package test.main;

import test.mypac.Calculator;

public class MainClass04 {
	public static void main(String[] args) {
		
		Calculator add1=new Calculator() {
			@Override
			public int calc(int num1, int num2) {
			
				return num1+num2;
			}
		};
		
		Calculator add2=(int num1,int num2)->{ 
			return num1+num2;
		};
		
		Calculator add3=(num1,num2)->num1+num2;
		
		int result1 = add1.calc(10, 20);
		int result2 = add2.calc(10, 20);
		int result3 = add3.calc(10, 20);
		
		System.out.println("result1:"+result1);
		System.out.println("result2:"+result2);
		System.out.println("result3:"+result3);
	}
}







