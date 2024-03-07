package com.jspider.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.personPojo;
import com.jspider.springmvc.repository.personRepository;


@Service
public class personService {
	@Autowired
	private personRepository repository;

		public personPojo insertPerson(String name, String email) {
			personPojo pojo = repository.addPerson(name,email);
			return pojo;
		}

		public personPojo searchPerson(String name) {
			personPojo pojo=repository.searchPerson(name);
			return pojo;
		}

}
