package com.i5jie.ticket.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.util.TokenProcessor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.i5jie.ticket.utils.Token;

public class TokenInterceptor extends HandlerInterceptorAdapter{

    @SuppressWarnings("unchecked")
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        

        String path=request.getRequestURI();
		
				String context=request.getContextPath();
		
				context=path.substring(context.length());
        
        /**
         * 每次请求生成Token
         */
        Map<String, String> tokensMap = null;
        
        if(request.getSession().getAttribute("tokensMap") == null){
        	tokensMap = new HashMap<String, String>();
        }
        else{
        	tokensMap = (Map<String, String>)request.getSession().getAttribute("tokensMap");
        }
        
        tokensMap.put(context, TokenProcessor.getInstance().generateToken(request));
        
        request.getSession().setAttribute("tokensMap", tokensMap);
        //
        
        Token annotation = method.getAnnotation(Token.class);
        if (annotation != null) {
           //验证token防止重复提交
        	String token = request.getParameter("token");
        	if(token != null){
        		
        		String key = token.split("@")[0];
        		String tokens = token.split("@")[1];
        		
        		if(tokensMap.containsKey(key) && tokensMap.get(key).equals(tokens)){
        			
        			tokensMap.remove(key);
        			request.getSession().setAttribute("tokensMap", tokensMap);
        		}
        		else{
        			request.getRequestDispatcher("/resubmit").forward(request, response);
        			return false;   
        		}
        	}
        	else{
        		request.getRequestDispatcher("/resubmit").forward(request, response);
        		return false;   
        	}
        	
        }
        return true;
    }


}
