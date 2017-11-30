package test.main;

import test.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작 되었습니다.");
		
		//회원정보를 누적할 배열 객체 생성
		MemberDto[] members=new MemberDto[3];
		
		//MemberDto 객체에 각각의 회원정보 저장하기 
		MemberDto dto1=new MemberDto();
		dto1.setNum(1);
		dto1.setName("김구라");
		dto1.setAddr("노량진");
		
		MemberDto dto2=new MemberDto(2, "해골", "행신동");
		
		members[0]=dto1;
		members[1]=dto2;
		members[2]=new MemberDto(3, "원숭이", "상도동");;
		
//		for(int i=0; i<members.length; i++) {
//			MemberDto tmp=members[i];
//			showInfo(tmp);
//		}
		
		for(MemberDto tmp:members) {
			showInfo(tmp);
		}
		
//		showInfo(members[0]);
//		showInfo(members[1]);
//		showInfo(members[2]);
	}
	
	// static 맴버 메소드
	public static void showInfo(MemberDto dto) {
		System.out.println("번호:"+dto.getNum());
		System.out.println("이름:"+dto.getName());
		System.out.println("주소:"+dto.getAddr());
		System.out.println("----------------");
	}
}

















