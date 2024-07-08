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
}