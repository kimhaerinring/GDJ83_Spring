package com.sun.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sun.app.member.MemberDAO.";

	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "join", memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
	}

	public MemberDTO logout(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "logout", memberDTO);
	}

	public MemberDTO mypage(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "mypage", memberDTO);
	}
}
