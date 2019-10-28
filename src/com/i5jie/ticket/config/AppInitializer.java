package com.i5jie.ticket.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		
		servletContext.setInitParameter("webAppRootKey", "TcTicket.root");
		
		//开启日志
		servletContext.setInitParameter("log4jConfigLocation","/WEB-INF/classes/log4j.properties");
		
		servletContext.addListener(org.springframework.web.util.Log4jConfigListener.class);
		
		webApplicationContext.register(AppConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

		dynamic.addMapping("/");
		dynamic.addMapping("*.html");

		dynamic.setLoadOnStartup(1);

		// 字符过滤
		Dynamic charset = servletContext.addFilter("charset", CharacterEncodingFilter.class);

		charset.setInitParameter("encoding", "UTF-8");
		charset.setInitParameter("forceEncoding", "true");

		charset.addMappingForUrlPatterns(null, false, "/*");

		//权限拦截器----------------暂时注释掉
		//Dynamic authority = servletContext.addFilter("authority", SessionFilter.class);
		//authority.addMappingForUrlPatterns(null, false, "/*");
	}

}
