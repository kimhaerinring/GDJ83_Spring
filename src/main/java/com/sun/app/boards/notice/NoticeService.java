package com.sun.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.app.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return noticeDAO.getList(pager);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}

	public void hit(NoticeDTO noticeDTO) throws Exception {
		noticeDAO.hit(noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
}
