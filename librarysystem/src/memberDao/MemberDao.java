package memberDao;

import memberDto.MemberDto;

//접속 아이디 admin/admin
/*
 * 회원가입
 * 회원삭제
 * 회원수정
 * 회원검색
 */
public class MemberDao {

		private static MemberDao dao;

		private MemberDao() {
		}
 
		public static MemberDao getInstance() {
			if (dao == null) {
				dao = new MemberDao();
			}
			return dao;
		}
		//회원가입
		public void joinMember(MemberDto dto) {
			
		}
		//회원 수정
		public void setMember() {
			
		}
		//회원탈퇴
		public void delMember() {
			
			
		}
		//회원찾기
		public void findMember() {
			
		}
	}
	


