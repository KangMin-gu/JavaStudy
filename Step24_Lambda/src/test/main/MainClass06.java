package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass06 {
	public static void main(String[] args) {
		
		List<String> names=new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		names.add("주뎅이");
		names.add("덩어리");
		
		for(String tmp:names) {
			System.out.println(tmp);
		}
		System.out.println("--------");
		
		names.forEach((tmp)->{
			System.out.println(tmp);
		});
	}
}












