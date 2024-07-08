package com.sun.app.accounts;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.DefaultTest;

public class AccountDAOTest extends DefaultTest {
	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void Detailtest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAc_num("123");
		accountDAO.detail(accountDTO);
		assertNotNull(accountDTO);
	}

}
