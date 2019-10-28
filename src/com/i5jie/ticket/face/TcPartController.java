package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcPart;
import com.i5jie.ticket.service.ITcPartService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcPart")
public class TcPartController extends BaseController {

	@Autowired
	ITcPartService tcPartService;


	@RequestMapping(value = "/tcPartBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcPartBrowse()
	{
		ModelAndView mv = getModelAndView("tcPartBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcPartList", tcPartService.tcPartListPage(qd));
		mv.addObject("qd", qd);
		
		return mv;
	}

	@RequestMapping(value = "/tcPartDetail",  method = RequestMethod.GET)
	public ModelAndView tcPartDetail(TcPart tcPart)
	{
		ModelAndView mv = getModelAndView("tcPartDetail");
		mv.addObject("tcPart", tcPartService.tcPartSingle(tcPart));

		return mv;
	}

	@RequestMapping(value = "/tcPartAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcPartAdd(TcPart tcPart  ,Integer[] tcPower_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcPart/tcPartBrowse");
		
		if(tcPartService.addTcPart(tcPart,tcPower_id) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcPartEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcPartEdit(TcPart tcPart  ,Integer[] tcPower_id ,RedirectAttributes rattr)
	{
				
		ModelAndView mv = redirectModelAndView("tcPart/tcPartBrowse");
		
		if(tcPartService.editTcPart(tcPart,tcPower_id)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcPartRemove",  method = RequestMethod.GET)
	public ModelAndView tcPartRemove(TcPart tcPart,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcPart/tcPartBrowse");
		
		if(tcPartService.removeTcPart(tcPart)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcPartEditPage",  method = RequestMethod.GET)
	public ModelAndView tcPartEditPage(TcPart tcPart)
	{
		ModelAndView mv = getModelAndView("tcPartEditPage");
		mv.addObject("tcPart", tcPartService.tcPartSingle(tcPart));

								
		mv.addObject("tcPowerList", tcPartService.selectTcPowerName());
		mv.addObject("tcPowerValueList", tcPartService.selectTcPowerList(tcPart));
		
				
		return mv;
	}

	@RequestMapping(value = "/tcPartAddPage",  method = RequestMethod.GET)
	public ModelAndView tcPartAddPage()
	{
		ModelAndView mv = getModelAndView("tcPartAddPage");

								
		mv.addObject("tcPowerList", tcPartService.selectTcPowerName());
		
						
		return mv;
	}

}