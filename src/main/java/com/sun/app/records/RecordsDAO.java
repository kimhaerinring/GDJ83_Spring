package com.sun.app.records;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecordsDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sun.app.records.RecordsDAO.";

	public int transfer(RecordsDTO recordsDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "transfer", recordsDTO);
	}

	public int transferU(RecordsDTO recordsDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "transferU", recordsDTO);
	}

}
