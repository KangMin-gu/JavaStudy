package test.main;

import test.dao.MemberDao;

public class MainClass08 {
	public static void main(String[] args) {
		MemberDao dao1 = MemberDao.getInstance();
		dao1.getList();
	}
}
