package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	public List<Customer> removeCustomer(int id) {
		customerRepository.deleteById(id);
		return customerRepository.findAll();
		
	}
	public Customer viewCustomer(int id) {
		return customerRepository.findById(id).get();
		
	}
	public Customer updateCustomer(int id,String MobNum) {
		Customer c=customerRepository.findById(id).get();
		c.setCustomerMobileNumber(MobNum);
		customerRepository.flush();
		return c;
	}
	public List<Customer> viewAllCustomer(){
		return customerRepository.findAll();
		
	}
	public List<Customer> viewAllCustomersByLocation(String location){
		return customerRepository.getByAddress(location) ;
		
	}
	
	
}
