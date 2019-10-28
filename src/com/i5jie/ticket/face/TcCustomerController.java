package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcCustomer;
import com.i5jie.ticket.service.ITcCustomerService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcCustomer")
public class TcCustomerController extends BaseController {

	@Autowired
	ITcCustomerService tcCustomerService;


	@RequestMapping(value = "/tcCustomerBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcCustomerBrowse()
	{
		ModelAndView mv = getModelAndView("tcCustomerBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcCustomerList", tcCustomerService.tcCustomerListPage(qd));
		mv.addObject("qd", qd);
		
		return mv;
	}

	@RequestMapping(value = "/tcCustomerDetail",  method = RequestMethod.GET)
	public ModelAndView tcCustomerDetail(TcCustomer tcCustomer)
	{
		ModelAndView mv = getModelAndView("tcCustomerDetail");
		mv.addObject("tcCustomer", tcCustomerService.tcCustomerSingle(tcCustomer));

		return mv;
	}

	@RequestMapping(value = "/tcCustomerAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcCustomerAdd(TcCustomer tcCustomer  ,Integer[] tcCompany_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcCustomer/tcCustomerBrowse");
		
		if(tcCustomerService.addTcCustomer(tcCustomer,tcCompany_id) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcCustomerEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcCustomerEdit(TcCustomer tcCustomer  ,Integer[] tcCompany_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcCustomer/tcCustomerBrowse");
		
		if(tcCustomerService.editTcCustomer(tcCustomer,tcCompany_id)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcCustomerRemove",  method = RequestMethod.GET)
	public ModelAndView tcCustomerRemove(TcCustomer tcCustomer,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcCustomer/tcCustomerBrowse");
		
		if(tcCustomerService.removeTcCustomer(tcCustomer)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcCustomerEditPage",  method = RequestMethod.GET)
	public ModelAndView tcCustomerEditPage(TcCustomer tcCustomer)
	{
		ModelAndView mv = getModelAndView("tcCustomerEditPage");
		mv.addObject("tcCustomer", tcCustomerService.tcCustomerSingle(tcCustomer));

								
		mv.addObject("tcCompanyList", tcCustomerService.selectTcCompanyName());
		mv.addObject("tcCompanyValueList", tcCustomerService.selectTcCompanyList(tcCustomer));
		
				
		return mv;
	}

	@RequestMapping(value = "/tcCustomerAddPage",  method = RequestMethod.GET)
	public ModelAndView tcCustomerAddPage()
	{
		ModelAndView mv = getModelAndView("tcCustomerAddPage");

								
		mv.addObject("tcCompanyList", tcCustomerService.selectTcCompanyName());
		
						
		return mv;
	}

}