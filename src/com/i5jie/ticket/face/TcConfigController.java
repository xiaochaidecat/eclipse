package com.i5jie.ticket.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.ticket.beans.TcConfig;
import com.i5jie.ticket.service.ITcConfigService;
import com.i5jie.ticket.utils.Token;
import com.i5jie.ticket.utils.plugin.QueryData;

@RestController
@RequestMapping("tcConfig")
public class TcConfigController extends BaseController {

	@Autowired
	ITcConfigService tcConfigService;


	@RequestMapping(value = "/tcConfigBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcConfigBrowse()
	{
		ModelAndView mv = getModelAndView("tcConfigBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("tcConfigList", tcConfigService.tcConfigListPage(qd));
		mv.addObject("qd", qd);
		
		return mv;
	}

	@RequestMapping(value = "/tcConfigDetail",  method = RequestMethod.GET)
	public ModelAndView tcConfigDetail(TcConfig tcConfig)
	{
		ModelAndView mv = getModelAndView("tcConfigDetail");
		mv.addObject("tcConfig", tcConfigService.tcConfigSingle(tcConfig));

		return mv;
	}

	@RequestMapping(value = "/tcConfigAdd",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcConfigAdd(TcConfig tcConfig ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcConfig/tcConfigBrowse");
		
		if(tcConfigService.addTcConfig(tcConfig) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcConfigEdit",  method = RequestMethod.POST)
	@Token
	public ModelAndView tcConfigEdit(TcConfig tcConfig ,RedirectAttributes rattr)
	{
			
		ModelAndView mv = redirectModelAndView("tcConfig/tcConfigBrowse");
		
		if(tcConfigService.editTcConfig(tcConfig)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
		
		}

	@RequestMapping(value = "/tcConfigRemove",  method = RequestMethod.GET)
	public ModelAndView tcConfigRemove(TcConfig tcConfig,RedirectAttributes rattr)
	{
		ModelAndView mv = redirectModelAndView("tcConfig/tcConfigBrowse");
		
		if(tcConfigService.removeTcConfig(tcConfig)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
}

	@RequestMapping(value = "/tcConfigEditPage",  method = RequestMethod.GET)
	public ModelAndView tcConfigEditPage(TcConfig tcConfig)
	{
		ModelAndView mv = getModelAndView("tcConfigEditPage");
		mv.addObject("tcConfig", tcConfigService.tcConfigSingle(tcConfig));

				
		return mv;
	}

	@RequestMapping(value = "/tcConfigAddPage",  method = RequestMethod.GET)
	public ModelAndView tcConfigAddPage()
	{
		ModelAndView mv = getModelAndView("tcConfigAddPage");

						
		return mv;
	}

}