package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;
	@GetMapping("/customer")
	@ResponseBody
	public Iterable<Customer> customer(){
		return repo.findAll();
	}
}
