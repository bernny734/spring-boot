package com.map.domain;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

//設計一份合約 佈署關於資料庫存取有關的元件(Spring Bean)
//註冊resource檔案appliction.properties
@Configuration
//@PropertySource({"classpath:custom.properties"}) //應用系統資源檔application.properties不用特別註冊

public class DBMapComponent {
	//注入環境物件 依賴環境物件
	@Autowired
	private Environment env;
	//自訂建構子
	public DBMapComponent() {
		System.out.println("合約注入工廠了...");
	}
	
	//透過方法method as Spring Bean配置,方法名稱當作一個類型
	@SuppressWarnings("deprecation")
	@Bean //描述成一個Spring Bean
	public DataSource myDataSource() {
		SQLServerDataSource ds=new SQLServerDataSource();
		System.out.println(env.getProperty("spring.datasource.driver-class-name"));
		ds.setTrustServerCertificate(true);
		ds.setEncrypt(true);
		ds.setUser(env.getProperty("spring.datasource.username"));
		ds.setURL(env.getProperty("spring.datasource.url"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		ds.setApplicationName(env.getProperty("spring.datasource.applicationname"));
		return ds;
	}

}