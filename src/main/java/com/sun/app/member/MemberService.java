package com.sun.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.app.accounts.AccountDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPassword().equals(memberDTO.getPassword())) {
				// 로그인 성공

				return result;
			} else {

				return null;
			}
		}

		return result;

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

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}
}
