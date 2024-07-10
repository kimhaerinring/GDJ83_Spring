package com.sun.app.accounts;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.app.member.MemberDTO;
import com.sun.app.member.MemberService;
import com.sun.app.records.RecordsDTO;

@Controller
@RequestMapping("/accounts/*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, HttpSession session) throws Exception {
		String id = ((MemberDTO) session.getAttribute("member")).getId();
		accountDTO.setId(id);
		int result = accountService.add(accountDTO);
		return "redirect:/";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(Model model, AccountDTO accountDTO) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("account", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer(Model model, AccountDTO accountDTO) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("dto", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(Model model, HttpSession httpSession, RecordsDTO recordsDTO) throws Exception {
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		int num = accountService.transfer(memberDTO, recordsDTO);
		if (num == -1) {
			model.addAttribute("result", "존재하지 않는 계좌번호입니다.");
			model.addAttribute("url", "/member/mypage");
			return "/commons/message";
		}
		return "redirect:/member/mypage";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model, ListOption listOption) throws Exception {
		List<RecordsDTO> ar = accountService.list(listOption);
		model.addAttribute("dtos", ar);
	}
}