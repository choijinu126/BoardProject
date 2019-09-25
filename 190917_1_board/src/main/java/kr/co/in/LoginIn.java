package kr.co.in;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.domain.UserVO;
import kr.co.service.UserService;

public class LoginIn extends HandlerInterceptorAdapter{
	@Autowired
	private UserService uservice;
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if(session.getAttribute("login") != null) {
				session.removeAttribute("login");
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		Object obj = modelAndView.getModel().get("vo");
		
		String suseCookie = request.getParameter("useCookie");
		boolean useCookie = Boolean.valueOf(suseCookie);
		
		if(obj != null) {
			if(useCookie){
				String id = ((UserVO) obj).getId();
				
				String jsid = session.getId();
				Cookie loginCookie = new Cookie("loginCookie", jsid);
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*2);
				response.addCookie(loginCookie);
				
				long validtime = System.currentTimeMillis()+1000*10;
				uservice.updateJsidNvalidtime(jsid, validtime, id);
			}
			
			//before jsession id process
//			if(useCookie) {
//				Cookie cid = new Cookie("id", ((UserVO) obj).getId());
//				cid.setMaxAge(60*2);
//				cid.setPath("/");
//				response.addCookie(cid);
//				Cookie cpw = new Cookie("pw",  ((UserVO) obj).getPw());
//				cpw.setMaxAge(60*2);
//				cpw.setPath("/");
//				response.addCookie(cpw);
//			}
			
			session.removeAttribute("err_login");
			session.setAttribute("login", obj);
			
			String dest = (String) session.getAttribute("dest");
			session.removeAttribute("dest");
			response.sendRedirect(dest != null ? dest : "/");
		}else {
			session.setAttribute("err_login", "아이디/비밀번호를 잘못 입력하셨습니다.");
			response.sendRedirect("/user/login");
		}
	}
}
