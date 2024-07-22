package com.sun.app.member;
import com.sun.app.files.*;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.tools.ForwardingJavaFileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sun.app.accounts.AccountDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private FileManager fileManager;
	
	private String name = "members";

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		int result = memberDAO.join(memberDTO);
		if (files == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();
		// 1. 어디에 저장? 운영체제가 알고있는 경로
		String path = servletContext.getRealPath("resources/upload/members");
		System.out.println(path);
		String fileName =fileManager.fileSave(path,files);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFilename(fileName);
		memberFileDTO.setOriname(files.getOriginalFilename());
		result = memberDAO.addFile(memberFileDTO);
		return result; // memberDAO.join(memberDTO);

		// return memberDAO.join(memberDTO);
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
