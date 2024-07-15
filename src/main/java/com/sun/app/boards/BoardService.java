package com.sun.app.boards;

import java.util.List;

import com.sun.app.util.Pager;

public interface BoardService {
//list
	public List<BoardDTO> getList(Pager pager) throws Exception;

//add
	public int add(BoardDTO boardDTO) throws Exception;

	public int update(BoardDTO boardDTO) throws Exception;

	public int delete(BoardDTO boardDTO) throws Exception;

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	void hit(BoardDTO boardDTO) throws Exception;
}
