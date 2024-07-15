package com.sun.app.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Long page, String kind, String search) throws Exception {
		System.out.println("notice list");
		Map<String, Object> map = noticeService.getList(page, kind, search);
		model.addAttribute("map", map);
	}

	@RequestMapping("detail")
	public String getDetail(Model model, NoticeDTO noticeDTO) throws Exception {
		NoticeDTO dto = noticeService.getDetail(noticeDTO);
		String path = "commons/message";
		if (dto != null) {
			model.addAttribute("dto", dto);
			path = "product/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수 없습니다요.");
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		String url = "";

		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서등록에 실패하셨습니다");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, NoticeDTO noticeDTO) throws Exception {
		NoticeDTO dto = noticeService.getDetail(noticeDTO);
		String url = "commons/message";
		if (dto != null) {
			model.addAttribute("dto", dto);
			url = "product/update";
		} else {
			model.addAttribute("result", "없는 부서");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);

		return "redirect:./list";

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
			model.addAttribute("result", "부서삭제에 실패하셨습니다");
			model.addAttribute("url", "./list");
		}
		return url;
	}
}
