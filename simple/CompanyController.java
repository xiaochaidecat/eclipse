package com.i5jie.autobuild.face;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i5jie.autobuild.beans.Company;
import com.i5jie.autobuild.service.CompanyService;
import com.i5jie.autobuild.service.ComponentService;
import com.i5jie.autobuild.utils.DateUtil;
import com.i5jie.autobuild.utils.plugin.QueryData;

@RestController
@RequestMapping("company")
public class CompanyController extends BaseController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	ComponentService componentService;
	
	@RequestMapping(value = "/companyBrowse",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView companyBrowse() {

		ModelAndView mv = getModelAndView("companyBrowse");
		
		QueryData qd = this.getQueryData();
		
		mv.addObject("companyList", companyService.companyListPage(qd));
		mv.addObject("qd", qd);
		mv.addObject("componentList", componentService.getComponentList());

		return mv;
	}
	
	@RequestMapping(value = "/companyAddPage",  method = RequestMethod.GET)
	public ModelAndView companyAddPage() {

		ModelAndView mv = getModelAndView("companyAddPage");
		
		mv.addObject("componentList", componentService.getComponentList());

		return mv;
	}
	
	@RequestMapping(value = "/companyAdd",  method = RequestMethod.POST)
	public ModelAndView companyAdd(Company company,Integer[] component_id,RedirectAttributes rattr) {

		ModelAndView mv = redirectModelAndView("company/companyBrowse");
		
		if(companyService.addCompany(company) > 0){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		return mv;
	}
	
	@RequestMapping(value = "/companyEditPage",  method = RequestMethod.GET)
	public ModelAndView companyEditPage(Company company) {

		ModelAndView mv = getModelAndView("companyEditPage");
		mv.addObject("company", companyService.companySingle(company));
		mv.addObject("componentList", componentService.getComponentList());

		return mv;
	}
	
	@RequestMapping(value = "/companyEdit",  method = RequestMethod.POST)
	public ModelAndView companyEdit(Company company,Integer[] component_id,RedirectAttributes rattr) {

		ModelAndView mv = redirectModelAndView("company/companyBrowse");
		
		if(companyService.editCompany(company)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
	}
	

	@RequestMapping(value = "/companyDetial",  method = RequestMethod.GET)
	public ModelAndView companyDetial(Company company) {

		ModelAndView mv = getModelAndView("companyDetial");
		mv.addObject("company", companyService.companySingle(company));

		return mv;
	}
	
	@RequestMapping(value = "/companyRemove",  method = RequestMethod.GET)
	public ModelAndView companyRemove(Company company,RedirectAttributes rattr) {

		ModelAndView mv = redirectModelAndView("company/companyBrowse");
		
		if(companyService.removeCompany(company)){
			rattr.addFlashAttribute("successMsg", "操作成功！");
		}
		else{
			rattr.addFlashAttribute("errorMsg", "操作失败！");
		}
		
		return mv;
		
	}
	
	/*
	 * 导出到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){

		QueryData qd = this.getQueryData();
		ModelAndView mv = null;
		
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("名称");
			titles.add("创建时间");
			dataMap.put("titles", titles);
			List<Company> varOList = companyService.companyListPage(qd);
			List<QueryData> varList = new ArrayList<QueryData>();
			for(int i=0;i<varOList.size();i++){
				QueryData vpd = new QueryData();
				vpd.put("var1", varOList.get(i).getName());
				vpd.put("var2", DateUtil.datefomat(varOList.get(i).getCreateTime(),1));
				varList.add(vpd);
			}
			dataMap.put("varList", varList);
			
			mv = getObjectExcelView(dataMap);
		} catch(Exception e){
			e.printStackTrace();
		}
		return mv;
	}
}
