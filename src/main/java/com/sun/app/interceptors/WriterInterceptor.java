package com.sun.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.app.boards.BoardDTO;
import com.sun.app.member.MemberDTO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WriterInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method=request.getMethod();
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		
		MemberDTO memberDTO=(MemberDTO)request.getSession().getAttribute("member");
		Map<String,Object>map =modelAndView.getModel();
		Iterator<String>iterator=map.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		BoardDTO boardDTO =(BoardDTO)map.get("dto");
		boardDTO.getBoardWriter();
		if(!boardDTO.getBoardWriter().equals(memberDTO.getId())) {
		//	modelAndView.setViewName("redirect:/");
			modelAndView.setViewName("commons/message");
			modelAndView.addObject("result","작성자만 가능");
			modelAndView.addObject("url", "/");
		}
		
	}
}
