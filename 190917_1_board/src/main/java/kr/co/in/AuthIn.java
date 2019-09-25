package kr.co.in;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthIn extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("login") != null) {
				return true;
			} else {
				saveDest(request);
				response.sendRedirect("/user/login");
				return false;
			}
		} else {
			saveDest(request);
			response.sendRedirect("/user/login");
			return false;
		}
	}
	
	private void saveDest(HttpServletRequest request) {
		HttpSession session =request.getSession();
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if(query==null || query.equals("nulll")) {
			query = "";
		}else {
			query = "?" + query;
		}
		
		String me = request.getMethod();
		if(me.equalsIgnoreCase("get")) {
			session.setAttribute("dest", uri+query);
		}
	}
}
