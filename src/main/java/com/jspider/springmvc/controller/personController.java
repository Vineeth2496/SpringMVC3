package com.jspider.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvc.pojo.personPojo;
import com.jspider.springmvc.service.personService;



@Controller
public class personController {
	
	@Autowired
	private personService service;
	
	@GetMapping("/insert")
	public String insertPerson() {
		return "Insert";
	}
	
	
	@PostMapping("/insert")
	public String addPerson(@RequestParam String name,
								@RequestParam String email,
								ModelMap map) {
	personPojo	pojo = service.insertPerson(name, email);
	
		if (pojo != null) {
			map.addAttribute("msg", "Data inserted successfully. ");
			return "Insert";
		}
		
		map.addAttribute("msg", "Data not inserted. ");
		return "Insert";
	}

	
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	 
	@PostMapping("/search")
	public String searchPerson(@RequestParam String name,
			ModelMap map) {
		personPojo pojo=service.searchPerson(name);
	
		if(pojo != null) {
			map.addAttribute("person",pojo);
			map.addAttribute("msg","person record found.");
			return "Search";
		}
		
		
		
		map.addAttribute("msg", "person data does not exist");
		return "Search";
	}

}
