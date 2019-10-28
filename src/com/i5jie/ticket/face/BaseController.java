package com.i5jie.ticket.face;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.i5jie.ticket.utils.ObjectExcelView;
import com.i5jie.ticket.utils.plugin.QueryData;

@Controller
@RequestMapping("/")
public class BaseController {//abstract

	/**
	 * 拦截通用HTML
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "*.html", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView anyWay(HttpServletRequest request) {

		String url = request.getRequestURI();

		String context = request.getContextPath();

		if (url.equals(context + "/")) {

			url = "login";

		} else {

			url = url.substring(context.length() + 1, url.lastIndexOf(".html"));

		}

		ModelAndView mv = getModelAndView(url);

		return mv;

	}
	
	@RequestMapping(value = "resubmit", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView resubmit(HttpServletRequest request) {

		ModelAndView mv = getModelAndView("resubmit");

		return mv;

	}
	
	/**
	 * 单纯页面跳转
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{page}",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView skippage(@PathVariable("page") String page,HttpServletRequest request) {

		ModelAndView mv = getModelAndView(page);
		return mv;
	}

	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(String viewName) {

		ModelAndView mv = new ModelAndView(viewName);

		String context = getRequest().getContextPath();
		
		String path=getRequest().getRequestURI();
		
		mv.addObject("ctx", context);
		
		mv.addObject("uri", path.substring(context.length()));
		
		return mv;
	}
	
	public ModelAndView redirectModelAndView(String viewName) {

		ModelAndView mv = getModelAndView("redirect:/"+viewName);

		return mv;
	}
	
	public ModelAndView getObjectExcelView(Map<String,Object> dataMap) {

		ObjectExcelView erv = new ObjectExcelView();

		ModelAndView mv = new ModelAndView(erv,dataMap);
		
		return mv;
	}
	
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

		return request;
	}
	
	/**
	 * 得到request对象
	 */
	public HttpSession getSession() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request.getSession();
	}
	
	public QueryData getQueryData(){
		return new QueryData(this.getRequest());
	}
}
