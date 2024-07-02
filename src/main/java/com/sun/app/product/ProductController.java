package com.sun.app.product;

import java.util.List;

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
	public void getList(Model model) throws Exception {
		System.out.println(" list");
		List<ProductDTO> ar = productService.getList();
		model.addAttribute("list", ar);
	}

	@RequestMapping("detail")
	public String getDetail(Model model, String p_code) throws Exception {
		ProductDTO productDTO = productService.getDetail(p_code);

		String path = "commons/message";
		if (productDTO != null) {
			model.addAttribute("dto", productDTO);
			path = "product/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수 없습니다요.");
			model.addAttribute("url", "./list");
		}
		return path;

	}
}
