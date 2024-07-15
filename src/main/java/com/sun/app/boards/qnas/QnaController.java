package com.sun.app.boards.qnas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@GetMapping("list")
	public ModelAndView list(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("board/list");
		return modelAndView;
	}

	@GetMapping("detail")
	public String getDetail() throws Exception {
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}

	@GetMapping("update")
	public String update() throws Exception {
		return "board/update";
	}
}
