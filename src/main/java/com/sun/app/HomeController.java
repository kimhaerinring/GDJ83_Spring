package com.sun.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home(HttpServletRequest request) {

		System.out.println("study conflict");
		// 하위 내장 객체에서 -> 상위 객체 꺼내기 가능
		// 상위-> 하위 X
		HttpSession session = request.getSession();
		System.out.println("master");
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}
//		Cookie cookie = new Cookie("test", "KIMHAERIN");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);
		System.out.println(request.getRemoteAddr() + ": ");
		return "index";
	}

}