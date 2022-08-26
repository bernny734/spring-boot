package com.tainan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tainan.entity.food;


@Controller
@RequestMapping(path="/map")
public class MapController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private HttpServletRequest request;
	@RequestMapping(path= {"/qryarea"},method= {RequestMethod.GET})
	public String AdministrativeAreaByTainan(Model model,String area) {
		String sql="select distinct area from vwtainan";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		List<String> data=new ArrayList<>();
		
		result.stream().forEach(
				c->{
					data.add(c.get("area").toString());
				});
		
		model.addAttribute("data",data);
		return "AreaTainan";
	}
	
	@RequestMapping(path= {"/index.html"},method= {RequestMethod.GET})
	public String home(Model model,String area) {
		String sql="select distinct area from vwtainan";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		List<String> data=new ArrayList<>();
		
		result.stream().forEach(
				c->{
					data.add(c.get("area").toString());
				});
		
		model.addAttribute("data",data);
		return "index1";
	}
	
}
