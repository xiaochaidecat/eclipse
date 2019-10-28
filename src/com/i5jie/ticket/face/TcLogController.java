package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcLog;
import com.i5jie.ticket.service.ITcLogService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcLog")
public class TcLogController extends BaseController {

	@Autowired
	ITcLogService tcLogService;

	
	
	
	@RequestMapping(value = "/tcLogBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcLogBrowse()
	{
		ModelAndView mv = getModelAndView("tcLogBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcLogList", tcLogService.tcLogListPage(qd));
		mv.addObject("qd", qd);
						
		mv.addObject("tcUserNameList", tcLogService.selectTcUserName());
		
				
		mv.addObject("tcOrderNumberList", tcLogService.selectTcOrderNumber());
		
				
		return mv;
	}

	@RequestMapping(value = "/tcLogDetail",  method = RequestMethod.GET)
	public ModelAndView tcLogDetail(TcLog tcLog)
	{
		ModelAndView mv = getModelAndView("tcLogDetail");
		mv.addObject("tcLog", tcLogService.tcLogSingle(tcLog));

		return mv;
	}

	@RequestMapping(value = "/tcLogAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcLogAdd(TcLog tcLog ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcLog/tcLogBrowse");
		
		if(tcLogService.addTcLog(tcLog) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcLogRemove",  method = RequestMethod.GET)
	public ModelAndView tcLogRemove(TcLog tcLog,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcLog/tcLogBrowse");
		
		if(tcLogService.removeTcLog(tcLog)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcLogAddPage",  method = RequestMethod.GET)
	public ModelAndView tcLogAddPage()
	{
		ModelAndView mv = getModelAndView("tcLogAddPage");

				
		mv.addObject("tcUserNameList", tcLogService.selectTcUserName());
		
				
		mv.addObject("tcOrderNumberList", tcLogService.selectTcOrderNumber());
		
						
		return mv;
	}

}