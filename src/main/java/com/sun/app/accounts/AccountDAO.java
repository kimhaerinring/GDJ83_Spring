package com.sun.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.trades.TradeDAO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private TradeDAO recordsDAO;

	private final String NAMESPACE = "com.sun.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}

//	public int transfer(TradeDTO recordsDTO) throws Exception {
//		int num = 0;
//		num += sqlSession.update(NAMESPACE + "transfer", recordsDTO);
//		num += sqlSession.update(NAMESPACE + "transferU", recordsDTO);
//		num += recordsDAO.transfer(recordsDTO);
//		num += recordsDAO.transferU(recordsDTO);
//		return num;
//	}

}