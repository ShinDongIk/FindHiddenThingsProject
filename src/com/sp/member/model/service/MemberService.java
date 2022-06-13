package com.sp.member.model.service;

import java.sql.Connection;

import com.sp.common.JDBCTemplate;

import com.sp.member.model.dao.MemberDao;
import com.sp.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
				
		Connection conn = JDBCTemplate.connect();
			
		Member m = new MemberDao().loginMember(conn,userId,userPwd);

		JDBCTemplate.close(conn);
		
		return m;
		
				
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.connect();
		
		int result = new MemberDao().insertMember(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int memberDelete(String userId, String userPwd) {
		Connection conn = JDBCTemplate.connect();
		
		int result = new MemberDao().memberDelete(conn,userId ,userPwd);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public int idCheck(String userId) {
		Connection conn = JDBCTemplate.connect();
		
		int result = new MemberDao().idCheck(conn,userId);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int NickNameCheck(String userNickName) {
		Connection conn = JDBCTemplate.connect();
		
		int result = new MemberDao().NickNameCheck(conn,userNickName);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}
