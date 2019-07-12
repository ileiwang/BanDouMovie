package xyz.leiwang.bandoumovie.exception;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import xyz.leiwang.bandoumovie.exception.DIYException;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:44:02
*/
public class GlobalException implements HandlerExceptionResolver{
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setHeader("refresh", "5;url=/shop/index.action");
		DIYException exception =null;
		if(ex instanceof DIYException){
			exception=(DIYException)ex;
		}else{
			exception.setMessage("发生了未知异常");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMessage",exception.getMessage()+"系统将在5秒之后跳转到首页......");
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
