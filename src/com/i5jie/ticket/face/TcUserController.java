package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcUser;
import com.i5jie.ticket.service.ITcUserService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcUser")
public class TcUserController extends BaseController {

	@Autowired
	ITcUserService tcUserService;


	@RequestMapping(value = "/tcUserBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcUserBrowse()
	{
		ModelAndView mv = getModelAndView("tcUserBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcUserList", tcUserService.tcUserListPage(qd));
		mv.addObject("qd", qd);
		
		return mv;
	}

	@RequestMapping(value = "/tcUserDetail",  method = RequestMethod.GET)
	public ModelAndView tcUserDetail(TcUser tcUser)
	{
		ModelAndView mv = getModelAndView("tcUserDetail");
		mv.addObject("tcUser", tcUserService.tcUserSingle(tcUser));

		return mv;
	}

	@RequestMapping(value = "/tcUserAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcUserAdd(TcUser tcUser  ,Integer[] tcPart_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcUser/tcUserBrowse");
		
		if(tcUserService.addTcUser(tcUser,tcPart_id) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcUserEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcUserEdit(TcUser tcUser  ,Integer[] tcPart_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcUser/tcUserBrowse");
		
		if(tcUserService.editTcUser(tcUser,tcPart_id)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcUserRemove",  method = RequestMethod.GET)
	public ModelAndView tcUserRemove(TcUser tcUser,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcUser/tcUserBrowse");
		
		if(tcUserService.removeTcUser(tcUser)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcUserEditPage",  method = RequestMethod.GET)
	public ModelAndView tcUserEditPage(TcUser tcUser)
	{
		ModelAndView mv = getModelAndView("tcUserEditPage");
		mv.addObject("tcUser", tcUserService.tcUserSingle(tcUser));

								
		mv.addObject("tcPartList", tcUserService.selectTcPartName());
		mv.addObject("tcPartValueList", tcUserService.selectTcPartList(tcUser));
		
				
		return mv;
	}

	@RequestMapping(value = "/tcUserAddPage",  method = RequestMethod.GET)
	public ModelAndView tcUserAddPage()
	{
		ModelAndView mv = getModelAndView("tcUserAddPage");

								
		mv.addObject("tcPartList", tcUserService.selectTcPartName());
		
						
		return mv;
	}

}