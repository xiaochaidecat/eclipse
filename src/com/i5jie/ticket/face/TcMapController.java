package com.i5jie.ticket.face;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.i5jie.ticket.beans.ReturnResult;
import com.i5jie.ticket.beans.TcMap;
import com.i5jie.ticket.beans.TcMapUser;
import com.i5jie.ticket.beans.TcUser;
import com.i5jie.ticket.service.ITcMapService;
import com.i5jie.ticket.utils.plugin.QueryData;


@RestController
@RequestMapping("tcMap")
public class TcMapController extends BaseController {

	@Autowired
	ITcMapService tcMapService;
	
	//查询围栏类表
	@RequestMapping(value = "/tcMapUserBrowse",
					method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcMapUserBrowse() {
		ModelAndView mv = getModelAndView("tcMapUserBrowse");
		
		QueryData qd = this.getQueryData();
		System.out.println(qd+"========");
		mv.addObject("tcMapUserList", tcMapService.tcMapListPage(qd));
		mv.addObject("qd", qd);
		
		return mv;
	}
	
	//添加围栏跳转
	@RequestMapping(value = "/tcMapAddPage",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tcMapAddPage() {
		ModelAndView mv = getModelAndView("tcMapAddPage");
	
		return mv;
		
	}
	
	@RequestMapping(value = "/tcAddMap",
			method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnResult tcAddMap(String path,String mapName,HttpSession session) {
		
		//创建时间
		java.util.Date d = new java.util.Date();
		Date date = new Date(d.getTime());
		
		//创建人
		TcUser loginUser = (TcUser) session.getAttribute("loginUser");
		
		//围栏详细信息对象
		TcMapUser tcMapUser = new TcMapUser(loginUser, date,mapName, null);
		System.out.println(tcMapUser);
		
		//插入操作
		tcMapService.addMapUser(tcMapUser);
		
		//经度串
		StringBuffer node_longitude = new StringBuffer();
		
		//维度串
		StringBuffer node_latitude = new StringBuffer();
		
		//判断经纬度计数器
		int count = 1;
		
		System.out.println(path);
		String[] split = path.split(",");
		TcMap tcMap = new TcMap();
		tcMap.setMapId(tcMapUser.getId());
		for (int i = 0; i < split.length; i++) {
			if (count%2!=0) {
				tcMap.setNode_longitude(split[i]);
			}else {
				tcMap.setNode_latitude(split[i]);
			}
			if (tcMap.getNode_latitude()!=null&&tcMap.getNode_longitude()!=null) {
				System.out.println(tcMap);
				boolean bool = tcMapService.addMap(tcMap);
				tcMap.setNode_longitude(null);
				tcMap.setNode_latitude(null);
			}
			
			count++;
		}
		
		//返回结果集对象
		ReturnResult result = new ReturnResult();
		
		return result;
	}
	
	//详情

	@RequestMapping(value = "/tcGetMap",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getMap(Integer tcMapUserId) {
		System.out.println(tcMapUserId);
		TcMapUser tcMapUser = tcMapService.getMapUserById(tcMapUserId);
		ModelAndView mView = getModelAndView("tcMapDetail");
		mView.addObject("tcMapUser", tcMapUser);
		
		return mView;
	}
	
	
}
