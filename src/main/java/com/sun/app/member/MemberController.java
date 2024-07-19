package com.sun.app.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() {
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		System.out.println(session.getServletContext());
		System.out.println(files.getName());
		System.out.println(files.getOriginalFilename());
		System.out.println(files.getSize());
		int result = memberService.join(memberDTO, files, session);
		String url = "";
		if (result > 0) {
			url = "redirect:/";
		}
		return url;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(name = "remember ", required = false, defaultValue = "") String value)
			throws Exception {
		model.addAttribute("id", value);
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("remember")) {
//				request.setAttribute("io", c.getValue());
//			}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, MemberDTO memberDTO, String remember, HttpServletResponse response,
			HttpSession session) throws Exception {
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPassword());

		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		memberDTO = memberService.login(memberDTO);
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
		} else {
			model.addAttribute("result", "다시입력하쇼");
			model.addAttribute("url", "/member/login");
			return "/commons/message";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // session의 유지 시간을 0으로
		// session.setAtribute("member"null)
		// session.removerAttribute("member")
		return "redirect:/";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		model.addAttribute("member", memberDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		model.addAttribute("member", memberDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, Model model) throws Exception {
		int result = memberService.update(memberDTO);
		memberDTO = memberService.login(memberDTO);
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
		}

		return "redirect:/";

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model, MemberDTO memberDTO, HttpSession session) throws Exception {
		int result = memberService.delete(memberDTO);
		if (result > 0) {
			session.setAttribute("member", null);
		}
		return "redirect:/";
	}
}
