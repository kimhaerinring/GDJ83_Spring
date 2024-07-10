package com.sun.app.trades;

import org.springframework.stereotype.Service;

import com.sun.app.accounts.AccountDTO;

@Service
public class TradeService {
	private TradeDAO tradeDAO;

	public int trade(TradeDTO tradeDTO, AccountDTO accountDTO) throws Exception {
		// 1번 계좌에서 5000월을 4444계좌로 이체
		AccountDTO accountDTO = new TradeDTO();
		accountDTO.setAccountNumber(tradeDTO.getAccountNumber);
		accountDTO = accountDAO.detail(accountDTO);
		tradeDTO.setAccountNumber("1");
		tradeDTO.setTradeAmount(5000L * -1);
		tradeDTO.setTradeIO(1);
		// 거래내역 추가
		int result = tradeDAO.add(tradeDTO);
		// 거래내용 업데이트
		tradeDAO.update(tradeDTO);

		// 받는 DTO로 수정
		tradeDTO.setAccountNumber(tradeDTO.getReceiveNumber());
		tradeDTO.setTradeAmount(tradeDTO.getTradeAmount() * -1);
		tradeDTO.setTradeIO(0);
		// 받는 계좌 거래내역 추가
		result = tradeDAO.add(tradeDTO);
		// 받는 계좌 내용을 업데이트
		result = tradeDAO.update(tradeDTO);
		return result;
	}
}
