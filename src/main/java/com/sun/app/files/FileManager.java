package com.sun.app.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.SessionAttributeMethodArgumentResolver;
@Component
public class FileManager {
//HDD에 파일 저장
	//fileSave
	//1. 저장할 폴더 지정

	public String fileSave (String path,MultipartFile files) throws Exception {
		//1. 저장폴더
	File file = new File(path);
	if (!file.exists()) {
		file.mkdirs();	
	}
 //2. 폴더의 저장할 파일명 생성
	String fileName=UUID.randomUUID().toString();
	fileName =fileName+"_"+files.getOriginalFilename();

	//3. 하드디스크에 파일 저장
	file =new File(file,fileName);
	files.transferTo(file);
	return fileName;
	
	}
}
