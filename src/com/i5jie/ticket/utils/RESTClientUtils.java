package com.i5jie.ticket.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 调用restful接口工具类
 * @author CLOUD
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
@Component
public class RESTClientUtils<T> {
    
	@Autowired
    private RestTemplate template;

    private final static String baseuri = "";//PropertiesReader.getInstance().getProperty("baseuri")

    /**
     * 查询数组
     * @param method
     * @param tarray
     * @return
     */
	public List<T> queryForList(String method,T t) {
		
		T[] tarray = (T[]) Array.newInstance(t.getClass(), 0);
		
		T[] result = (T[])template.postForObject(baseuri + method, getEntity(t), tarray.getClass());
		
		if(result != null){
			return Arrays.asList(result);
		}
		
		return null;
    }
	
	/**
     * 查询数量
     * @param method
     * @param tarray
     * @return
     */
	public Long queryForCount(String method,T t) {
		
		return template.postForObject(baseuri + method, getEntity(t), Long.class);
    }

	/**
	 * 查询单个对象
	 * @param method
	 * @param t
	 * @return
	 */
    public T queryForObject(String method,T t) {

    	return (T)template.postForObject(baseuri + method,getEntity(t), t.getClass());

    }
    
    /**
     * 添加数据
     * @param method
     * @param t
     * @return
     */
    public Long createObject(String method,T t) {

    	return template.postForObject(baseuri + method,getEntity(t), Long.class);

    }

    /**
     * 编辑数据
     * @param method
     * @param t
     * @return
     */
    public boolean editObject(String method,T t) {

    	return template.postForObject(baseuri + method,getEntity(t), Boolean.class);

    }

    /**
     * 删除数据
     * @param method
     * @param t
     * @return
     */
    public boolean removeObject(String method,T t) {

    	return template.postForObject(baseuri + method,getEntity(t), Boolean.class);

    }
    
    /**
     * 放置传递参数
     * @param t
     * @return
     */
    private HttpEntity<T> getEntity(T t){
    	
    	HttpHeaders headers = new HttpHeaders();

    	return new HttpEntity<T>(t, headers);
    }
    
    /**
     * 查询数量
     * @param method
     * @param tarray
     * @return
     */
	public Double queryForDouble(String method,T t) {
		
		return template.postForObject(baseuri + method, getEntity(t), Double.class);
    }
}
