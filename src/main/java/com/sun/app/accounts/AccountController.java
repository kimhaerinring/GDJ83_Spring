package com.sun.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.app.member.MemberDTO;
import com.sun.app.member.MemberService;
import com.sun.app.trades.TradeDTO;
import com.sun.app.trades.TradeService;

@Controller
@RequestMapping("/accounts/*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private TradeService tradeService;

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
	public String transfer(TradeDTO tradeDTO) throws Exception {
		// tradeDTO: 계좌번호가 1개
		// 보내는 계좌:accountNumber
		// 받는 계좌:receiverNumber 없음
		int result = tradeService.trade(tradeDTO);
		return "redirect:../member/mypage";
	}
}