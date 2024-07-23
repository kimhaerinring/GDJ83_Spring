package com.sun.app.boards.qnas;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sun.app.boards.BoardDAO;
import com.sun.app.boards.BoardDTO;
import com.sun.app.boards.BoardService;
import com.sun.app.files.FileDTO;
import com.sun.app.files.FileManager;
import com.sun.app.boards.BoardFileDTO;
import com.sun.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private FileManager fileManager;
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		// 1.rownum 계산
		pager.makeRow();
		// 2.paging 계산
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getList(pager);
	}

	public int add(BoardDTO boardDTO,HttpSession session, MultipartFile[] files) throws Exception {
		Integer num=qnaDAO.getNum();
		boardDTO.setBoardNum(num);
		int result = qnaDAO.add(boardDTO, session, files);
		
		if (files == null) {
			return result;
		}
		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/qna");
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
			result = qnaDAO.addFile(boardFileDTO);
		}
		return result;
	}
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}


	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.fileDetail(fileDTO);
	}

	@Override
	public void hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		// 1.step을 1씩 업데이트 함
		int result = qnaDAO.replyUpdate(parent);
		// 2. 답글에 REF,STEP,DEPTH를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		return qnaDAO.reply(qnaDTO);
	}


}
