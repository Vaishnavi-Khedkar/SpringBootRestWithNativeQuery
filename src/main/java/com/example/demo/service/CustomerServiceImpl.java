package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {

		return this.customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Integer custId) {
		return this.customerRepository.findById(custId);

	}

	@SuppressWarnings("deprecation")
	@Override
	public Customer updateCustomerById(Customer customer, Integer custId) {
		Customer byId = this.customerRepository.getById(custId);
		byId.setName(customer.getName());
		byId.setCity(customer.getCity());
		byId.setMobile(customer.getMobile());

		Customer save = this.customerRepository.save(byId);
		return save;

	}

	@Override
	public void deleteCustomerById(Integer custId) {
		this.customerRepository.deleteById(custId);

	}

	@Override
	public List<Customer> getCustomerByName(String customerName) {
		return this.customerRepository.getCustomerByName(customerName);
	}

	@Override
	public List<Customer> getCustomerByCity(String customerCity) {
		return this.customerRepository.getCustomerByCity(customerCity);
	}
}