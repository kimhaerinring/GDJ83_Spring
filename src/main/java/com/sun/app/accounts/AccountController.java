package com.sun.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.app.member.MemberDTO;

@Controller
@RequestMapping("/accounts/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

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
}
