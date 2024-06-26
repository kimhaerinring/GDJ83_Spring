package com.sun.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*") // 이걸로 시작하면 다 여기로옴
public class DepartmentController {

	// IOC : Inversion if controll
	// 객체 생성, 메서드 호출
	// controller,service,repository,component

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("departmen tlist");
		// return "/department/list" url 경로를 jsp경로로 이용
		List<DepartmentDTO> ar = departmentService.getList();

		// Model+view 2가지 방법
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("list",ar);
		// mv.setViewName("deprtment/list");
		// return mv;

		model.addAttribute("list", ar);
	}

//@RequestParam(name = "num",defaultValue="10")int department_id
	@RequestMapping("detail")
	public String getDetail(Model model, int department_id) throws Exception {

		System.out.println("detail");
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);

		String path = "commons/message";
		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수 없습니다요.");
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.add(departmentDTO);
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

	// delete
	@RequestMapping("delete")
	public String delete(Model model, DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.delete(departmentDTO);
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

	// update
	@RequestMapping("update")
	public String update(int department_id, Model model) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String url = "commons/message";
		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			url = "department/update";
		} else {
			model.addAttribute("result", "없는 부서");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.update(departmentDTO);

		return "redirect:./list";

	}

}
