package com.sun.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {
	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("12");
		memberDTO = memberDAO.login(memberDTO);
		assertEquals(1, memberDTO.getDtos().size());
	}
}
