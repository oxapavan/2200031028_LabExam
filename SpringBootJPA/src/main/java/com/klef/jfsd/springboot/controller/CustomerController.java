package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.service.CustomerService;

@RestController
@RequestMapping("student")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public String home() {
		return "Spring Boot Rest API Project";
	}

	@PostMapping("add")
	public String addstudent(@RequestBody Customer s) {
		return service.addstudent(s);
	}

	@GetMapping("viewall")
	public List<Customer> viewallstudents() {
		return service.viewallstudents();
	}

	@GetMapping("display")
	public Customer displaystudent(@RequestParam("id") int sid) {
		return service.viewstudentbyid(sid);
	}

	@DeleteMapping("delete")
	public String deletestudent(@RequestParam("id") int sid) {
		return service.deletestudent(sid);
	}

	@PutMapping("update")
	public String updatestudent(@RequestBody Customer s) {
		return service.updatestudent(s);
	}
}