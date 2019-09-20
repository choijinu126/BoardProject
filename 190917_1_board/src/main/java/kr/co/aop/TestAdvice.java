//package kr.co.aop;
//
//import java.util.Arrays;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import kr.co.domain.BoardVO;
//
//@Component
//@Aspect
//public class TestAdvice {
//	@Before("execution(* kr.co.service.BoardService*.*(..))")
//	public void startLog(JoinPoint jp) {
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>AOP Before test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println(Arrays.toString(jp.getArgs()));
//	}
//	
//	@After("execution(* kr.co.service.BoardService*.*(..))")
//	public void endLog() {
//		System.out.println("##############################################AOP After test##########################################");
//	}
//	
//	@Around("execution(* kr.co.service.BoardService*.*(..))")
//	public Object checkTime(ProceedingJoinPoint pjp) throws Throwable{
//		long start = System.currentTimeMillis();
//		
//		Object obj = pjp.proceed();
//		
//		long end = System.currentTimeMillis();
//		System.out.println("time@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + (end - start));
//		
//		BoardVO vo = null;
//		if(obj instanceof BoardVO) {
//			vo = (BoardVO) obj;
//			vo.setBno(109);
//			return vo;
//		}
//		
//		return obj;
//	}
//}
