package com.sun.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPassword().equals(memberDTO.getPassword())) {
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

		return memberDAO.mypage(memberDTO);
	}

}
