package com.sun.app.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.app.accounts.AccountDAO;
import com.sun.app.accounts.AccountDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);
	}

	public Map<String, Object> login(MemberDTO memberDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPassword().equals(memberDTO.getPassword())) {
				// 로그인 성공
				List<AccountDTO> ar = accountDAO.list(memberDTO);
				System.out.println(ar.size());
				map.put("member", result);
				map.put("accounts", ar);
				return map;
			} else {

				return null;
			}
		}

		return null;

	}

	public MemberDTO logout(MemberDTO memberDTO) throws Exception {

		return memberDAO.logout(memberDTO);
	}

	public MemberDTO mypage(MemberDTO memberDTO) throws Exception {
		return memberDTO;

	}

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}
}
