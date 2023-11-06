package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.vo.AccountVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	// 1. true를 반환   : 요청된 Controller를 이어서 수행
	// 2. false를 반환 : Controller를 실행하지 않고 중단 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cpath = request.getContextPath();
		
		HttpSession session = request.getSession();
		AccountVO user = (AccountVO)session.getAttribute("user");
		
		if (user == null) {
			response.sendRedirect(cpath + "/account/login");
			return false;
		}
		
		return true;
	}
}
