package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcSign;
import com.i5jie.ticket.service.ITcSignService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcSign")
public class TcSignController extends BaseController {

	@Autowired
	ITcSignService tcSignService;


	@RequestMapping(value = "/tcSignBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcSignBrowse()
	{
		ModelAndView mv = getModelAndView("tcSignBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcSignList", tcSignService.tcSignListPage(qd));
		mv.addObject("qd", qd);
						
		mv.addObject("tcUserNameList", tcSignService.selectTcUserName());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcSignDetail",  method = RequestMethod.GET)
	public ModelAndView tcSignDetail(TcSign tcSign)
	{
		ModelAndView mv = getModelAndView("tcSignDetail");
		mv.addObject("tcSign", tcSignService.tcSignSingle(tcSign));

		return mv;
	}

	@RequestMapping(value = "/tcSignAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcSignAdd(TcSign tcSign ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcSign/tcSignBrowse");
		
		if(tcSignService.addTcSign(tcSign) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcSignEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcSignEdit(TcSign tcSign ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcSign/tcSignBrowse");
		
		if(tcSignService.editTcSign(tcSign)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcSignRemove",  method = RequestMethod.GET)
	public ModelAndView tcSignRemove(TcSign tcSign,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcSign/tcSignBrowse");
		
		if(tcSignService.removeTcSign(tcSign)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcSignEditPage",  method = RequestMethod.GET)
	public ModelAndView tcSignEditPage(TcSign tcSign)
	{
		ModelAndView mv = getModelAndView("tcSignEditPage");
		mv.addObject("tcSign", tcSignService.tcSignSingle(tcSign));

				
		mv.addObject("tcUserNameList", tcSignService.selectTcUserName());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcSignAddPage",  method = RequestMethod.GET)
	public ModelAndView tcSignAddPage()
	{
		ModelAndView mv = getModelAndView("tcSignAddPage");

				
		mv.addObject("tcUserNameList", tcSignService.selectTcUserName());
		
						
		return mv;
	}

}