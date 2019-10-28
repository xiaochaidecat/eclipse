package com.i5jie.ticket.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.i5jie.ticket.utils.plugin.PagePlugin;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableTransactionManagement
public class DataConfig {

	private static BoneCPDataSource source;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {

		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		
		Resource[] res = {
								
					new ClassPathResource("mapper/TcReason.xml"),								
					new ClassPathResource("mapper/TcLog.xml"),								
					new ClassPathResource("mapper/TcPart.xml"),								
					new ClassPathResource("mapper/TcSign.xml"),								
					new ClassPathResource("mapper/TcCompany.xml"),								
					new ClassPathResource("mapper/TcConfig.xml"),								
					new ClassPathResource("mapper/TcUser.xml"),								
					new ClassPathResource("mapper/TcOrder.xml"),								
					new ClassPathResource("mapper/TcCustomer.xml"),
					new ClassPathResource("mapper/TcLogin.xml"),
					new ClassPathResource("mapper/TcMap.xml"),
					new ClassPathResource("mapper/TcMapUser.xml")
				}; 
		
		ssf.setMapperLocations(res);
		
		ssf.setDataSource(dataSource());
		
		ssf.setTypeAliasesPackage("com.i5jie.ticket.beans");
		
		Properties properties_log = new Properties();
		properties_log.setProperty("logImpl","LOG4J");
		
		ssf.setConfigurationProperties(properties_log);
		
		Interceptor pagePlugin = new PagePlugin();
		
		Properties properties = new Properties();
		properties.setProperty("dialect","mysql");
		properties.setProperty("pageSqlId",".*listPage.*");
		pagePlugin.setProperties(properties);

		Interceptor[] interceptor = {pagePlugin};
		ssf.setPlugins(interceptor);
		
		return ssf;

	}
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {

		MapperScannerConfigurer msc = new MapperScannerConfigurer();

		msc.setBasePackage("com.i5jie.ticket.dao");

		return msc;

	}
	
	@Bean
	public static DataSource dataSource() {

		if(source == null){
			
			source = new BoneCPDataSource();//config
			
			source.setDriverClass("com.mysql.jdbc.Driver");
			
			source.setUsername("root");
			source.setPassword("root");
			
			source.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/wmwj?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");

		}
		
		return source;
			
	}
	
	@Bean
   public PlatformTransactionManager transactionManager() {
       return new DataSourceTransactionManager(dataSource());
   }
}

