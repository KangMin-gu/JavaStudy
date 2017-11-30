package test.main;

import java.util.List;

import test.mypac.Calculator;

public class MainClass05 {
	public static void main(String[] args) {
		Calculator add=(a,b)->a+b;
		Calculator sub=(a,b)->a-b;
		Calculator mul=(a,b)->a*b;
		Calculator div=(a,b)->a/b;
		
		int result1=add.calc(10, 2);
		int result2=sub.calc(10, 2);
		int result3=mul.calc(10, 2);
		int result4=div.calc(10, 2);
		
	}
}









