package com.tainan.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.tainan","com.map.domain"})
public class TainanMapApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TainanMapApplication.class, args);
	}

}
