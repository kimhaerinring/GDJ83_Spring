package com.sun.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sun.app.boards.BoardDAO;
import com.sun.app.boards.BoardDTO;
import com.sun.app.boards.BoardService;
import com.sun.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	public List<BoardDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		long totalCount = boardDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return boardDAO.getList(pager);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return boardDAO.delete(boardDTO);
	}

	public void hit(BoardDTO boardDTO) throws Exception {
		boardDAO.hit(boardDTO);
	}

	public int add(BoardDTO boardDTO) throws Exception {
		return boardDAO.add(boardDTO);
	}
}
