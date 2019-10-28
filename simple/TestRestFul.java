package com.i5jie.autobuild.restful;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST接口测试类
 * @author CLOUD-KWB
 *
 */
@RestController
@RequestMapping("/testRestFul")
public class TestRestFul extends BasicRestFul{
	
	@RequestMapping(value = "/test/{str}", method = { RequestMethod.POST, RequestMethod.GET })
	public String selectWlTaskListBrowse(@PathVariable("str") String str) {

		return str;

	}

}
