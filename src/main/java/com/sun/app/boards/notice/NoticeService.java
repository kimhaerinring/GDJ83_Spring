package com.sun.app.boards.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sun.app.files.FileManager;
import com.sun.app.boards.BoardDAO;
import com.sun.app.boards.BoardDTO;
import com.sun.app.boards.BoardFileDTO;
import com.sun.app.boards.BoardService;
import com.sun.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	@Qualifier("noticeDAO")
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;

	public List<BoardDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return noticeDAO.getList(pager);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.delete(boardDTO);
	}
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return noticeDAO.addFile(boardFileDTO);
	}
	public void hit(BoardDTO boardDTO) throws Exception {
		noticeDAO.hit(boardDTO);
	}

	public int add(BoardDTO boardDTO,HttpSession session, MultipartFile[] files) throws Exception {
		Integer num=noticeDAO.getNum();
		boardDTO.setBoardNum(num);
		int result = noticeDAO.add(boardDTO, session, files);
		
		if (files == null) {
			return result;
		}
		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/notice");
		System.out.println(path);
//		File file = new File(path);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
		// 2. 폴더의 저장할 파일명 생성
		for (MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName =fileManager.fileSave(path,f);
			//4. 파일 정보를 DB 에서장
			//파일명, 오리지널, 파일번호
			BoardFileDTO boardFileDTO =new BoardFileDTO();
			boardFileDTO.setFilename(fileName);
			boardFileDTO.setOriname(f.getOriginalFilename());
			boardFileDTO.setBoardNum(num);
			System.out.println(boardFileDTO);
			result = noticeDAO.addFile(boardFileDTO);
		}
		return result;
}
}