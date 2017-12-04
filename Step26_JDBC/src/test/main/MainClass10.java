package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass10 {
	public static void main(String[] args) {
		// 99번 회원을 삭제 하려면?
		int num = 999;

		MemberDao dao = MemberDao.getInstance();
		boolean isSuccess = dao.delete(num);
		if (isSuccess) {
			System.out.println("success");
		} else {
			System.out.println("false");
		}
	}
}
