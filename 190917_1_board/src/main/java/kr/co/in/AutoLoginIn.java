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

public class AutoLoginIn extends HandlerInterceptorAdapter{
	@Autowired
	private UserService uservice;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Cookie[] arr = request.getCookies();
		Cookie loginCookie = null;
		if (arr != null) {
			for (Cookie x : arr) {
				if (x.getName().equals("loginCookie")) {
					loginCookie = x;
					break;
				}
			}
			
			if(loginCookie != null) {
			String jsid = loginCookie.getValue();
			UserVO vo = uservice.autoselect(jsid);
			
			long curTime = System.currentTimeMillis();
				if(vo.getValidtime() > curTime) {
					HttpSession session = request.getSession();
					session.setAttribute("login", vo);
					loginCookie.setMaxAge(60*2);
					response.addCookie(loginCookie);
					uservice.updateJsidNvalidtime(jsid, curTime+1000*60*2, vo.getId());
				}
			}
		}
	      
	      //before jsession id process
//	      Cookie cid = null;
//	      Cookie cpw = null;
//	      if(arr!=null) {
//	         for(Cookie x : arr) {
//	            if(x.getName().equals("id")) {
//	               cid = x;
//	               break;
//	            }
//	         }
//	         for(Cookie x : arr) {
//	            if(x.getName().equals("pw")) {
//	               cpw = x;
//	               break;
//	            }
//	         }
//	         
//	         if(cid !=null && cpw != null) {
//	            String id = cid.getValue();
//	            String pw = cpw.getValue();
//	            
//	            HttpSession session = request.getSession();
//	            session.setAttribute("login", new UserVO(id, pw, null));
//	         
//	            cid.setMaxAge(60*2);
//	            cpw.setMaxAge(60*2);
//	            
//	            response.addCookie(cid);
//	            response.addCookie(cpw);
//	         }
//	      }
	      return true;
	   }

	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	         ModelAndView modelAndView) throws Exception {
	   }

	}