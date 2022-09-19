package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public List<Customer> getCustomerByName(String customerName);

	public List<Customer> getCustomerByCity(String customerCity);

	public Optional<Customer> getCustomerById(Integer custId);

	public Customer updateCustomerById(Customer customer, Integer custId);

	public void deleteCustomerById(Integer custId);

}
