package com.tainan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tainan.entity.SayHelloMessage;
import com.tainan.entity.food;



@RestController
public class MapService {
	
		@Autowired
		private JdbcTemplate jdbcTemplate;
	
		//打招呼 text/plain 稱呼為MIME Type(Content-Type)
		@RequestMapping(path= {"/api/hello"},method= {RequestMethod.GET},produces="text/html") 
		//呈現網頁內容text後面改成html text後面如果是plain為原始檔
		public String sayHello() {
			return "<font size='6' color='red'>您好 吃飽沒 Hello World</font>";
		}
		
		@RequestMapping(path= {"/api/hello/data"},method= {RequestMethod.GET},produces="application/json")
		public SayHelloMessage sayHello2() {
			//
			SayHelloMessage msg = new SayHelloMessage();
			msg.setWho("薩摩耶");
			msg.setHello("汪");
			msg.setAddress("白沙灘");
			return msg;
		}		
	
	@RequestMapping(path= {"/map/area/{key}/rawdata"},method= {RequestMethod.GET},produces="application/json")
	public List<food> administrativeAreaQryByTainan(@PathVariable("key")String area) {
		List<food> result=jdbcTemplate.query("select area,緯度,經度,地址,店名,評價分數,評論人數,照片,更新時間 from vwtainan where area=?",  //緯度,經度,地址,店名,評價分數,評論人數,照片,更新時間
				BeanPropertyRowMapper.newInstance(food.class),
				new Object[] {area}
		);
		
		return result;
	}		
	}


