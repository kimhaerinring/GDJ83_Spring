package com.sun.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.member.MemberDTO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sun.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public List<AccountDTO> list(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", memberDTO);
	}
}