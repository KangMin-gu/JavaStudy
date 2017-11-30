package test.main;

import java.util.ArrayList;

import test.dto.MemberDto;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 *  3 명의 회원정보를 각각 MemberDto 객체에 담고
		 *  ArrayList 객체에 MemberDto 객체의 참조값을 
		 *  누적 시켜 보세요.
		 */
		
		MemberDto dto1=new MemberDto(1, "김구라", "노량진");
		MemberDto dto2=new MemberDto(2, "해골", "행신동");
		MemberDto dto3=new MemberDto(3, "원숭이", "상도동");
		
		ArrayList<MemberDto> members=new ArrayList<MemberDto>();
		members.add(dto1);
		members.add(dto2);
		members.add(dto3);
		
	}
}










