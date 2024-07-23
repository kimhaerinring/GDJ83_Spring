package com.sun.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.sun.app.util.Pager;
import com.sun.app.files.FileDTO;
public interface BoardDAO {
	// NoticeDAO,QnaDAO
	// totalCount
	public Long getTotalCount(Pager pager) throws Exception;

	// list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;

//add
	public int add(BoardDTO boardDTO,HttpSession session, MultipartFile[] files) throws Exception;

	// update
	int update(BoardDTO boardDTO) throws Exception;

	
//delete
	int delete(BoardDTO boardDTO) throws Exception;

//detail
	BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	void hit(BoardDTO boardDTO) throws Exception;

	 Integer getNum()throws Exception;

	 int addFile(BoardFileDTO boardFileDTO)throws Exception;
	 
	 //fileDetail
	 public FileDTO fileDetail (FileDTO fileDTO) throws Exception;
}