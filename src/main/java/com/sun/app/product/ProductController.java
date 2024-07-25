package com.sun.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sun.app.boards.qnas.QnaDTO;
import com.sun.app.member.MemberDTO;
import com.sun.app.util.Pager;
import com.sun.app.util.ProductCommentPager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("commentAdd")
	public String commentAdd(ProductCommentsDTO productCommentsDTO, HttpSession session,Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		productCommentsDTO.setId(memberDTO.getId());
		int result = productService.commentAdd(productCommentsDTO);
		
		model.addAttribute("msg",result);
		return "commons/result";
	}
	
	
	@GetMapping("addWish")
public String addWish(String p_code, HttpSession session,Model model)throws Exception {
MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
int result=productService.addWish(p_code, memberDTO.getId());
model.addAttribute("msg",result);
	return "commons/result";
}
	@GetMapping("wishList")
	public void wishList(HttpSession session,Model model) throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		List<ProductDTO>ar =productService.wishList(memberDTO);
		model.addAttribute("list",ar);
	}
	@GetMapping("commentList")
	public void commentList(Model model,ProductCommentPager productCommentPager) throws Exception{
		List<ProductCommentsDTO>ar =productService.commentList(productCommentPager);
		model.addAttribute("list",ar);
		model.addAttribute("pager",productCommentPager);
		
	}
	
	@PostMapping("commentDelete")
	public String commentDelete(ProductCommentsDTO productCommentsDTO,Model model) throws Exception {
		
		int result=productService.commentDelete(productCommentsDTO);
		model.addAttribute("msg",result);
			return "commons/result";
		}
	
	
	@GetMapping("deleteWishList")
	public String deleteWishList(String [] p_code,Model model,HttpSession session) throws Exception{
		for(String bn:p_code) {
			
		}
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		int result=productService.deleteWishList(p_code, memberDTO.getId());
		model.addAttribute("msg",result);
			return "commons/result";
	}
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Pager pager) throws Exception {
		System.out.println(" list");
		List<ProductDTO> list = productService.getList(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
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
	public String add(ProductDTO productDTO, HttpSession session, MultipartFile[] files) throws Exception {
		int result = productService.add(productDTO, session, files);
		String url = "";

		if (result > 0) {
			url = "redirect:./list";

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
