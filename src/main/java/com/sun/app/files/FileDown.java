package com.sun.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView{
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		Iterator<String> keys=model.keySet().iterator();
//		while(keys.hasNext()) {
//			String k=keys.next();
//			System.out.println(k);
//		}
		FileDTO fileDTO=(FileDTO)model.get("file");
		String directory=(String)model.get("board");
		//1. 폴더 경로 준비
		String path=request.getSession().getServletContext().getRealPath("/resources/upload/"+directory);
		//2. 파일 준비
		File file =new File(path,fileDTO.getFilename());
		//3. 응답시 인코딩 처리 -파일 명이 한글일경우 대비(Fileter로 처리 했으면 안대도됨)
		response.setCharacterEncoding("UTF-8");
		//4. 파일의 크기 지정
		response.setContentLength((int)file.length());
		//5. 다운로드시 파일 이름을 지정, 인코딩 설정
		String name = fileDTO.getOriname();
		name=URLEncoder.encode(name,"UTF-8");
		//6. Header정도 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+name+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//7. 클라이언트에게 전송
		//하드디스크에서 파일을 읽어와서 클라이언트로 output
		FileInputStream fileInputStream=new FileInputStream(file);
		OutputStream outputStream=response.getOutputStream();
		FileCopyUtils.copy(fileInputStream, outputStream);		
		//8. 해제
		outputStream.close();
		fileInputStream.close();
		System.out.println("fileDownLoadView");
		
	}
}
