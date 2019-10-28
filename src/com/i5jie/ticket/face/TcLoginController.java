package com.i5jie.ticket.face;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i5jie.ticket.beans.ReturnResult;
import com.i5jie.ticket.beans.TcUser;
import com.i5jie.ticket.service.ITcLoginService;
import com.i5jie.ticket.utils.MD5;



@Controller
@RequestMapping("Login")
public class TcLoginController{
	
	@Autowired
	private ITcLoginService ITcLoginService;
	
	@RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnResult tcLogin(String loginname,String password,String code,HttpSession session) {
		//鍒涘缓涓�涓繑鍥炲璞�
		ReturnResult ReturnResult = new ReturnResult();
		//鑾峰彇鐢熸垚鐨勯獙璇佺爜鐨勫��
		String strcode = (String) session.getAttribute("sessionSecCode");
		System.out.println(strcode+"========");
		System.out.println(code+"========");
		//楠岃瘉
		if (!code.equals(strcode)) {
			ReturnResult.setResult("codeerror");
			return ReturnResult;
		}
		
		//鍒涘缓涓�涓敤鎴峰璞�
		TcUser user = new TcUser();
		//缁欑敤鎴峰璞¤祴鍊�
		//传过来的账号秘密
		user.setPassword(password);
		user.setLoginname(loginname);
	
        //
		TcUser tcUser = ITcLoginService.login(user);
		System.out.println(tcUser);
		System.out.println(tcUser.getPassword()+"真实");
		
		String userPassword=MD5.md5(user.getPassword()+123);
		System.out.println(userPassword);
		//没查到用户或者用户账号不对
		if (tcUser==null||!tcUser.getPassword().equals(userPassword)) {
			ReturnResult.setResult("usererror");
		}else if(tcUser.getPassword().equals(userPassword)){
			ReturnResult.setResult("success");
		}
		session.setAttribute("loginUser", tcUser);
		
		return ReturnResult;
	}
}
