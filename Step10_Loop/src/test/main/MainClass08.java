package test.main;

import test.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작 되었습니다.");
		MemberDto dto1=new MemberDto();
		//메소드를 이용해서 회원정보 저장하기
		dto1.setNum(2);
		dto1.setName("해골");
		dto1.setAddr("행신동");
		
		MemberDto dto2=new MemberDto(1, "김구라", "노량진");
		// static 맴버 메소드 호출하면서 MemberDto  객체의 
		// 참조값 전달하기 
		MainClass08.showInfo(dto1);
		showInfo(dto2);
	}
	
	// static 맴버 메소드
	public static void showInfo(MemberDto dto) {
		System.out.println("번호:"+dto.getNum());
		System.out.println("이름:"+dto.getName());
		System.out.println("주소:"+dto.getAddr());
		System.out.println("----------------");
	}
}

















