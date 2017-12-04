package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {

		// 아래의 정보를 DB에 저장하려면?
		int num = 99;
		String name = "누구게";
		String addr = "어디게";

		// 저장할 회원정보를 MemberDto 객체에 담고
		MemberDto dto = new MemberDto(num, name, addr);
		// MeberDao 객체의 참조값 얻어오기
		MemberDao dao = MemberDao.getInstance();
		// 저장하기
		boolean isSuccess = dao.insert(dto);
		if (isSuccess) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
	}
}
