package com.i5jie.autobuild.restful;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

/**
 * 基类Controller
 * @author CLOUD
 *
 */
@RestController
public class BasicRestFul {

	//response.setHeader("Access-Control-Allow-Origin", "*");
	protected Map<String, Object> queryMap = new HashMap<String, Object>();//查询用MAP

	public Map<String, Object> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, Object> queryMap) {
		this.queryMap = queryMap;
	}
	
}
