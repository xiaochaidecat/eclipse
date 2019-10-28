package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcReason;
import com.i5jie.ticket.service.ITcReasonService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcReason")
public class TcReasonController extends BaseController {

	@Autowired
	ITcReasonService tcReasonService;


	@RequestMapping(value = "/tcReasonBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcReasonBrowse()
	{
		ModelAndView mv = getModelAndView("tcReasonBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcReasonList", tcReasonService.tcReasonListPage(qd));
		mv.addObject("qd", qd);
						
		mv.addObject("tcOrderStageList", tcReasonService.selectTcOrderStage());
		
				
		mv.addObject("tcUserNameList", tcReasonService.selectTcUserName());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcReasonDetail",  method = RequestMethod.GET)
	public ModelAndView tcReasonDetail(TcReason tcReason)
	{
		ModelAndView mv = getModelAndView("tcReasonDetail");
		mv.addObject("tcReason", tcReasonService.tcReasonSingle(tcReason));

		return mv;
	}

	@RequestMapping(value = "/tcReasonAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcReasonAdd(TcReason tcReason ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcReason/tcReasonBrowse");
		
		if(tcReasonService.addTcReason(tcReason) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcReasonEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcReasonEdit(TcReason tcReason ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcReason/tcReasonBrowse");
		
		if(tcReasonService.editTcReason(tcReason)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcReasonRemove",  method = RequestMethod.GET)
	public ModelAndView tcReasonRemove(TcReason tcReason,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcReason/tcReasonBrowse");
		
		if(tcReasonService.removeTcReason(tcReason)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcReasonEditPage",  method = RequestMethod.GET)
	public ModelAndView tcReasonEditPage(TcReason tcReason)
	{
		ModelAndView mv = getModelAndView("tcReasonEditPage");
		mv.addObject("tcReason", tcReasonService.tcReasonSingle(tcReason));

				
		mv.addObject("tcUserNameList", tcReasonService.selectTcUserName());
		
				
		mv.addObject("tcOrderStageList", tcReasonService.selectTcOrderStage());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcReasonAddPage",  method = RequestMethod.GET)
	public ModelAndView tcReasonAddPage()
	{
		ModelAndView mv = getModelAndView("tcReasonAddPage");

				
		mv.addObject("tcUserNameList", tcReasonService.selectTcUserName());
		
				
		mv.addObject("tcOrderStageList", tcReasonService.selectTcOrderStage());
		
						
		return mv;
	}

}