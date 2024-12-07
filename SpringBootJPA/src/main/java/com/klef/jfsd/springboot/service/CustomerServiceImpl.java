package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;

	@Override
	public String addstudent(Customer s) {
		repository.save(s);
		return "Student Added Successfully";
	}

	@Override
	public String updatestudent(Customer s) {
		Optional<Customer> object = repository.findById(s.getId());
		String msg = null;
		if (object.isPresent()) {
			Customer student = object.get();

			student.setAge(s.getAge());
			student.setContact(s.getContact());
			student.setDepartment(s.getDepartment());
			student.setEmail(s.getEmail());
			student.setGender(s.getGender());
			student.setName(s.getName());

			repository.save(student);
			msg = "Student Updated Successfully";
		} else {
			msg = "Student ID Not Found";
		}
		return msg;
	}

	@Override
	public String deletestudent(int sid) {
		Optional<Customer> object = repository.findById(sid);
		String msg = null;
		if (object.isPresent()) {
			Customer s = object.get();
			repository.delete(s);
			msg = "Student Deleted Successfully";
		} else {
			msg = "Student ID Not Found";
		}
		return msg;
	}

	@Override
	public Customer viewstudentbyid(int sid) {
		return repository.findById(sid).get();
	}

	@Override
	public List<Customer> viewallstudents() {
		return (List<Customer>) repository.findAll();
	}

}