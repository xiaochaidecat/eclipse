package com.i5jie.ticket.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件工具类
 */
public class PropertiesReader {

	public static final String PROPERTY_FILE = "conf.properties";

	private static PropertiesReader instance = null;

	private static Properties paraProps = new Properties();

	public PropertiesReader() throws IOException {
		InputStream is = getClass().getResourceAsStream("/" + PROPERTY_FILE);
		try {
			paraProps.load(is);
		} catch (Exception e) {
			System.err.println("不能读取属性文件. " + "请确保" + PROPERTY_FILE
					+ "在CLASSPATH指定的路径中");
		} finally {
			is.close();
		}
	}

	public static synchronized PropertiesReader getInstance(){
		if (instance == null) {
			try {
				instance = new PropertiesReader();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;

	}

	public String getProperty(String paraName) {
		return paraProps.getProperty(paraName);
	}

	public static void main(String[] args) {
		PropertiesReader propertiesReader;
		try {
			propertiesReader = new PropertiesReader();
			System.out.println(propertiesReader.getProperty("ip"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
