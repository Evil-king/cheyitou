package com.cheyitou.common.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


public class ExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		 Map<String, Object> model = new HashMap<String, Object>();  
	        model.put("ex", ex);  
	        Map<String,Object> map=new HashMap<String,Object>();
	        if(ex instanceof BaseException){
	        		map.put("code",((BaseException) ex).getcode());
	        		map.put("msg", ((BaseException) ex).getMsg());
	        }
		return new ModelAndView(new MappingJackson2JsonView(),map);
	}

}
