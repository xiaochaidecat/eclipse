package com.i5jie.ticket.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {
	
	static List<String> fileExtName=new ArrayList<String>();
	static List<String> whiteName=new ArrayList<String>();
	
	private void loadDefault(){
		
		//设置不拦截的扩展名
		fileExtName.add(".css");
		fileExtName.add(".js");
		fileExtName.add(".jpg");
		fileExtName.add(".png");
		fileExtName.add(".gif");
		fileExtName.add(".json");
		fileExtName.add(".ttf");
		fileExtName.add(".woff");
		fileExtName.add(".eot");
		fileExtName.add(".map");

		//设置不拦截的路径地址
		whiteName.add("/");//跳转到登录页面
	}

	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(fileExtName.size()==0 ||whiteName.size()==0 ){
			
			fileExtName.clear();
			whiteName.clear();
			loadDefault();
			
		}

		String path=request.getRequestURI();
		
		String context=request.getContextPath();
		
		context=path.substring(context.length());
		
		String menuFlag = request.getParameter("menu");
        if(menuFlag!=null){        	
        	request.getSession().setAttribute("menu", menuFlag);
        }
        else{
        	request.getSession().setAttribute("menu", 0);
        }
		
		Object login =request.getSession().getAttribute("userLogin");
		if(canPassFileExt(context) ||canPassWhiteFile(context) ){
			
			filterChain.doFilter(request, response);
			
		}else if(login == null){
			
			response.sendRedirect(request.getContextPath());
			
		}else{
			
			filterChain.doFilter(request, response);
		}
			
	}
	
	private boolean canPassFileExt(String path){
		
		if(path==null)return false;

		path=path.toLowerCase();
		
		for(String tmp:fileExtName){
			
			if(tmp==null)continue;
			
			tmp=tmp.toLowerCase();
			
			if(path.endsWith(tmp)){
				
				return true;
				
			}
		}
		
		return false;
		
	}
	
	private boolean canPassWhiteFile(String path){
		
		if(path==null)return false;
	
		path=path.toLowerCase();

		for(String tmp:whiteName){
			
			if(tmp==null)continue;

			tmp=tmp.toLowerCase();
			
			if(path.endsWith(tmp)){
				
				return true;
				
			}
		}
		
		return false;		
	}

}
