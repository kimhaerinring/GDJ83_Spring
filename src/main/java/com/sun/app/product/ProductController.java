package com.sun.app.product;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Long page) throws Exception {
		System.out.println(" list");
		Map<String, Object> map = productService.getList(page);
		model.addAttribute("map", map);
	}

	@RequestMapping("detail")
	public String getDetail(Model model, ProductDTO productDTO) throws Exception {
		ProductDTO dto = productService.getDetail(productDTO);

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
	public void add() {
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.add(productDTO);
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

	@RequestMapping("delete")
	public String delete(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
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
	public String update(ProductDTO productDTO, Model model) throws Exception {
		ProductDTO dto = productService.getDetail(productDTO);
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
	public String update(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);

		return "redirect:./list";

	}

}
