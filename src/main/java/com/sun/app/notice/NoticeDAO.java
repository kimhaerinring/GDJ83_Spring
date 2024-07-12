package com.sun.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.Pager;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sun.app.notice.NoticeDAO.";

	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	public List<NoticeDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}
}
