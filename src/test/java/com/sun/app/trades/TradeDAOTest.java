package com.sun.app.trades;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.DefaultTest;

public class TradeDAOTest extends DefaultTest {
	@Autowired
	private TradeDAO tradeDAO;
	private TradeDTO tradeDTO;

	@Before
	public void before() {
		this.tradeDTO = new TradeDTO();
		tradeDTO.setAccountNumber("4154");
		tradeDTO.setTradeAmount(2000L * -1);
		tradeDTO.setTradeIO(1);
	}

	// @Test
	public void addTest() throws Exception {
		int result = tradeDAO.add(tradeDTO);
	}

	@Test
	public void updateTest() throws Exception {
		int result = tradeDAO.update(tradeDTO);
		assertNotEquals(0, result);
	}

	@After
	public void after() {
		tradeDTO = null;
	}
}
