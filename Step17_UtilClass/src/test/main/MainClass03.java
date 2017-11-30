package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass03 {
	public static void main(String[] args) {
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		//List 의 방의 갯수 만큼 반복문 돌면서 
		for(int i=0; i<names.size(); i++) {
			//순서대로 참조 하기 
			String tmp=names.get(i);
			
			System.out.println(tmp);
		}
		System.out.println("--- 확장  for 문 사용 ---");
		
		for(String tmp:names) {
			System.out.println(tmp);
		}
	}
}











