package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Customer;

public interface CustomerService
{
	public String addstudent(Customer s);
	public String updatestudent(Customer s);
	public String deletestudent(int sid);
	public Customer viewstudentbyid(int sid);
	public List<Customer> viewallstudents();
}
