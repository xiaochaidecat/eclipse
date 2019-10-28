package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcOrder;
import com.i5jie.ticket.service.ITcOrderService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcOrder")
public class TcOrderController extends BaseController {

	@Autowired
	ITcOrderService tcOrderService;


	@RequestMapping(value = "/tcOrderBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcOrderBrowse()
	{
		ModelAndView mv = getModelAndView("tcOrderBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcOrderList", tcOrderService.tcOrderListPage(qd));
		mv.addObject("qd", qd);
						
		mv.addObject("tcCourierNameList", tcOrderService.selectTcCourierName());
		
				
		mv.addObject("tcUserNameList", tcOrderService.selectTcUserName());
		
				
		mv.addObject("tcCompanyNameList", tcOrderService.selectTcCompanyName());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcOrderDetail",  method = RequestMethod.GET)
	public ModelAndView tcOrderDetail(TcOrder tcOrder)
	{
		ModelAndView mv = getModelAndView("tcOrderDetail");
		mv.addObject("tcOrder", tcOrderService.tcOrderSingle(tcOrder));

		return mv;
	}

	@RequestMapping(value = "/tcOrderAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcOrderAdd(TcOrder tcOrder ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcOrder/tcOrderBrowse");
		
		if(tcOrderService.addTcOrder(tcOrder) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcOrderEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcOrderEdit(TcOrder tcOrder ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcOrder/tcOrderBrowse");
		
		if(tcOrderService.editTcOrder(tcOrder)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcOrderRemove",  method = RequestMethod.GET)
	public ModelAndView tcOrderRemove(TcOrder tcOrder,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcOrder/tcOrderBrowse");
		
		if(tcOrderService.removeTcOrder(tcOrder)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcOrderEditPage",  method = RequestMethod.GET)
	public ModelAndView tcOrderEditPage(TcOrder tcOrder)
	{
		ModelAndView mv = getModelAndView("tcOrderEditPage");
		mv.addObject("tcOrder", tcOrderService.tcOrderSingle(tcOrder));

				
		mv.addObject("tcUserNameList", tcOrderService.selectTcUserName());
		
				
		mv.addObject("tcCompanyNameList", tcOrderService.selectTcCompanyName());
		
				
		mv.addObject("tcCourierNameList", tcOrderService.selectTcCourierName());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcOrderAddPage",  method = RequestMethod.GET)
	public ModelAndView tcOrderAddPage()
	{
		ModelAndView mv = getModelAndView("tcOrderAddPage");

				
		mv.addObject("tcUserNameList", tcOrderService.selectTcUserName());
		
				
		mv.addObject("tcCompanyNameList", tcOrderService.selectTcCompanyName());
		
				
		mv.addObject("tcCourierNameList", tcOrderService.selectTcCourierName());
		
						
		return mv;
	}

}