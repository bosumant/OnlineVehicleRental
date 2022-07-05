package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
    public CustomerService customerService;
	
	@GetMapping("/addCustomer/{customer}")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
		
	}
	@PutMapping("/update/{customerId}/{customerMobileNumber}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId,@PathVariable("customerMobileNumber") String customerMobileNumber){
		return customerService.updateCustomer(customerId, customerMobileNumber);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public List<Customer> deleteCustomer(@PathVariable ("customerId") int customerId) {
		return customerService.removeCustomer(customerId);
	}
	@GetMapping("/ViewCustomer/{customerId}")
	public Customer viewCustomer(@PathVariable("customerId") int customerId) {
		return customerService.viewCustomer(customerId);
	}
	
	@GetMapping("/ViewAllCustomers/")
	public List<Customer> ViewAllCustomers() {
		return customerService.viewAllCustomer();
	}
	
	@GetMapping("/getAllCustomersAddress")
	public List<Customer> getAllCustomers(String location){
		return customerService.viewAllCustomersByLocation(location);
	}
}
