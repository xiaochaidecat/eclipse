package com.i5jie.ticket.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("com.i5jie.ticket" )
public class AppConfig {

	@Autowired
	ServletContext servletContext;

	@Autowired
	HttpServletRequest request;

	@Bean
	public ResourceHttpRequestHandler uploadHandler() {

		ResourceHttpRequestHandler font = new ResourceHttpRequestHandler();

		List<Resource> locations = new ArrayList<Resource>();

		ServletContextResource scr = new ServletContextResource(servletContext,"/uploads/");

		locations.add(scr);

		font.setLocations(locations);

		return font;

	}
	
	@Bean
	public ResourceHttpRequestHandler imgHandler() {

		ResourceHttpRequestHandler img = new ResourceHttpRequestHandler();

		List<Resource> locations = new ArrayList<Resource>();

		ServletContextResource scr = new ServletContextResource(servletContext,"/images/");

		locations.add(scr);

		img.setLocations(locations);

		return img;

	}

	@Bean
	public ResourceHttpRequestHandler cssHandler() {

		ResourceHttpRequestHandler css = new ResourceHttpRequestHandler();

		List<Resource> locations = new ArrayList<Resource>();

		ServletContextResource scr = new ServletContextResource(servletContext,"/css/");

		locations.add(scr);

		css.setLocations(locations);

		return css;

	}

	@Bean
	public ResourceHttpRequestHandler jsHandler() {

		ResourceHttpRequestHandler js = new ResourceHttpRequestHandler();

		List<Resource> locations = new ArrayList<Resource>();

		ServletContextResource scr = new ServletContextResource(servletContext,"/js/");

		locations.add(scr);

		js.setLocations(locations);

		return js;

	}

	@Bean
	public ResourceHttpRequestHandler fontsHandler() {

		ResourceHttpRequestHandler font = new ResourceHttpRequestHandler();

		List<Resource> locations = new ArrayList<Resource>();

		ServletContextResource scr = new ServletContextResource(servletContext,"/fonts/");

		locations.add(scr);

		font.setLocations(locations);

		return font;

	}

	@Bean
	public SimpleUrlHandlerMapping handlerMapping() {

		SimpleUrlHandlerMapping shm = new SimpleUrlHandlerMapping();

		Properties properties = new Properties();

		properties.setProperty("/js/**", "jsHandler");
		properties.setProperty("/css/**", "cssHandler");
		properties.setProperty("/images/**", "imgHandler");
		properties.setProperty("/fonts/**", "fontsHandler");
		properties.setProperty("/uploads/**", "uploadHandler");
		
		shm.setMappings(properties);

		return shm;

	}

	@Bean
	public VelocityViewResolver viewResolver() {

		VelocityViewResolver vvr = new VelocityViewResolver();

		vvr.setCache(true);

		vvr.setPrefix("");

		vvr.setSuffix(".html");

		vvr.setContentType("text/html;charset=UTF-8");
		
		vvr.setExposeSpringMacroHelpers(true);
		vvr.setExposeRequestAttributes(true);
		vvr.setExposeSessionAttributes(true);
		vvr.setRequestContextAttribute("rc");
		
		vvr.setDateToolAttribute("date");
		vvr.setNumberToolAttribute("num");

		return vvr;

	}

	@Bean
	public VelocityConfigurer velocityConfigurer() {

		VelocityConfigurer vc = new VelocityConfigurer();

		vc.setResourceLoaderPath("/vm/");

		Properties properties = new Properties();

		properties.setProperty("input.encoding", "utf-8");
		properties.setProperty("output.encoding", "utf-8");
		
		vc.setVelocityProperties(properties);

		return vc;

	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(30*1024*1024);
		multipartResolver.setMaxInMemorySize(10*1024*1024);
		return multipartResolver;
	}

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {

		SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();

		return smer;

	}
	
	@Bean
	public RestTemplate restTemplate(){
		
		RestTemplate rt=new RestTemplate();
		
		rt.getMessageConverters().add(new org.springframework.http.converter.FormHttpMessageConverter());
		
		return rt;
	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping(){
		
		RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
		
		//interceptor
		Object[] interceptors = {new TokenInterceptor()};
		rmhm.setInterceptors(interceptors);
		
		return rmhm;
	}
	
}
