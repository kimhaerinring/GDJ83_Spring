package com.sun.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sun.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}
}