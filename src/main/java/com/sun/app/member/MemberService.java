package com.sun.app.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}
		// 2. 파일명??
		// 1)
		Calendar calendar = Calendar.getInstance();
		long n = calendar.getTimeInMillis();
		// subString
		String origin = files.getOriginalFilename();
		origin = origin.substring(origin.lastIndexOf("."));
		String fileName = n + origin;
		System.out.println(fileName);
		fileName = n + "_" + files.getOriginalFilename();
		System.out.println(fileName);
		// 2)
		fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println(fileName);

		// 3.하드디스크에 파일 저장
		file = new File(file, fileName);
		// 1) MulltipartFile
		files.transferTo(file);
		// file Copy Utils
		// FileCopyUtils.copy(files.getBytes(), file);

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
