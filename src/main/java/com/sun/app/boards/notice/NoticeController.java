package com.sun.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sun.app.boards.BoardDTO;
import com.sun.app.files.FileDTO;
import com.sun.app.member.MemberDTO;
import com.sun.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Long page, Pager pager) throws Exception {
		System.out.println("notice list");
		List<BoardDTO> list = noticeService.getList(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);

		return "board/list";
	}

	@RequestMapping("detail")
	public String getDetail(Model model, NoticeDTO noticeDTO) throws Exception {
		BoardDTO dto = noticeService.getDetail(noticeDTO);
		String path = "commons/message";
		if (dto != null) {
			model.addAttribute("dto", dto);
			path = "board/detail";
		} else {
			model.addAttribute("result", "찾을 수 없습니다요.");
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, NoticeDTO noticeDTO ,HttpSession session,MultipartFile[] files) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		noticeDTO.setBoardWriter(memberDTO.getId());
		int result = noticeService.add(noticeDTO,session,files);
		return "redirect:./list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, NoticeDTO noticeDTO) throws Exception {
		BoardDTO dto = noticeService.getDetail(noticeDTO);
		String url = "commons/message";
		if (dto != null) {
			model.addAttribute("dto", dto);
			url = "board/update";
		} else {
			model.addAttribute("result", "없는 부서");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);

		return "redirect: ./list";

	}

	public void hit(NoticeDTO noticeDTO) throws Exception {
		noticeService.hit(noticeDTO);
	}

	@RequestMapping("delete")
	public String delete(Model model, NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		String url = "commons/message";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "게시글 삭제에 실패하셨습니다");
			model.addAttribute("url", "./list");
		}
		return url;
	}
	@GetMapping("fileDown")
	public void fileDown(FileDTO fileDTO)throws Exception  {
		fileDTO =noticeService.fileDetail(fileDTO);
		
		
	}
}
