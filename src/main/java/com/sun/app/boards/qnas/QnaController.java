package com.sun.app.boards.qnas;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.app.boards.BoardDTO;
import com.sun.app.member.MemberDTO;
import com.sun.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	private String conflict;

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}

	@GetMapping("list")
	public ModelAndView getList(Pager pager, ModelAndView modelAndView) throws Exception {
		List<BoardDTO> ar = qnaService.getList(pager);
		modelAndView.addObject("list", ar);

		modelAndView.setViewName("board/list");
		return modelAndView;

	}

	@GetMapping("detail")
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}

	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getId());
		int result = qnaService.add(qnaDTO);
		return "redirect:./list";
	}

	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", boardDTO);

		return "board/add";
	}

	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}

	@GetMapping
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}

	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("dto", qnaDTO);
		return "board/add";
	}

	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getId());
		int result = qnaService.reply(qnaDTO);
		return "redirect:./list";
	}
}
