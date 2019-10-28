package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcCompany;
import com.i5jie.ticket.service.ITcCompanyService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcCompany")
public class TcCompanyController extends BaseController {

	@Autowired
	ITcCompanyService tcCompanyService;


	@RequestMapping(value = "/tcCompanyBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcCompanyBrowse()
	{
		ModelAndView mv = getModelAndView("tcCompanyBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcCompanyList", tcCompanyService.tcCompanyListPage(qd));
		mv.addObject("qd", qd);
		
		return mv;
	}

	@RequestMapping(value = "/tcCompanyDetail",  method = RequestMethod.GET)
	public ModelAndView tcCompanyDetail(TcCompany tcCompany)
	{
		ModelAndView mv = getModelAndView("tcCompanyDetail");
		mv.addObject("tcCompany", tcCompanyService.tcCompanySingle(tcCompany));

		return mv;
	}

	@RequestMapping(value = "/tcCompanyAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcCompanyAdd(TcCompany tcCompany  ,Integer[] tcCustomer_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcCompany/tcCompanyBrowse");
		
		if(tcCompanyService.addTcCompany(tcCompany,tcCustomer_id) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcCompanyEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcCompanyEdit(TcCompany tcCompany  ,Integer[] tcCustomer_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcCompany/tcCompanyBrowse");
		
		if(tcCompanyService.editTcCompany(tcCompany,tcCustomer_id)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcCompanyRemove",  method = RequestMethod.GET)
	public ModelAndView tcCompanyRemove(TcCompany tcCompany,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcCompany/tcCompanyBrowse");
		
		if(tcCompanyService.removeTcCompany(tcCompany)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcCompanyEditPage",  method = RequestMethod.GET)
	public ModelAndView tcCompanyEditPage(TcCompany tcCompany)
	{
		ModelAndView mv = getModelAndView("tcCompanyEditPage");
		mv.addObject("tcCompany", tcCompanyService.tcCompanySingle(tcCompany));

								
		mv.addObject("tcCustomerList", tcCompanyService.selectTcCustomerName());
		mv.addObject("tcCustomerValueList", tcCompanyService.selectTcCustomerList(tcCompany));
		
				
		return mv;
	}

	@RequestMapping(value = "/tcCompanyAddPage",  method = RequestMethod.GET)
	public ModelAndView tcCompanyAddPage()
	{
		ModelAndView mv = getModelAndView("tcCompanyAddPage");

								
		mv.addObject("tcCustomerList", tcCompanyService.selectTcCustomerName());
		
						
		return mv;
	}

}