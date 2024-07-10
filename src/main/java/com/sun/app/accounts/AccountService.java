package com.sun.app.accounts;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		Calendar calendar = Calendar.getInstance();
		accountDTO.setAc_num(calendar.getTimeInMillis() + "");
		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}
//
//	public int transfer(MemberDTO memberDTO, TradeDTO recordsDTO) throws Exception {
//		for (AccountDTO accountDTO : memberDTO.getDtos()) {
//			if (accountDTO.getAc_num().equals(recordsDTO.getAc_num())) {
//				recordsDTO.setBalance(accountDTO.getA_balance());
//				return accountDAO.transfer(recordsDTO);
//			}
//		}
//		return -1;
//	}

}