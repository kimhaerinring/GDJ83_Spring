package com.sun.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public void getList() throws Exception {
		System.out.println("departmen tlist");
		// return "/department/list" url 경로를 jsp경로로 이용
		departmentService.getList();
	}
}
