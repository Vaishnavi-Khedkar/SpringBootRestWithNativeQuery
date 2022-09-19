package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

		Customer saveCustomer = this.customerService.saveCustomer(customer);
		return ResponseEntity.ok(saveCustomer);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> allCustomer = this.customerService.getAllCustomer();
		return ResponseEntity.ok(allCustomer);
	}

	@GetMapping("/byId/{custId}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@RequestBody @PathVariable Integer custId) {
		Optional<Customer> customerById = this.customerService.getCustomerById(custId);
		return ResponseEntity.ok(customerById);
	}

	@PutMapping("/update/{custId}")
	public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer, @PathVariable Integer custId) {
		Customer updateCustomerById = this.customerService.updateCustomerById(customer, custId);
		return ResponseEntity.ok(updateCustomerById);
	}

	@DeleteMapping("/delete/{custId}")
	public ResponseEntity<String> deleteCustomerById(@RequestBody @PathVariable Integer custId) {
		this.customerService.deleteCustomerById(custId);
		return ResponseEntity.ok("record deleted successfully");
	}

	@GetMapping("/byname/{customerName}")
	public ResponseEntity<List<Customer>> getCustomerByName(@RequestBody @PathVariable String customerName) {
		List<Customer> customerByName = this.customerService.getCustomerByName(customerName);
		return ResponseEntity.ok(customerByName);
	}

	@GetMapping("/bycity/{customerCity}")
	public ResponseEntity<List<Customer>> getCustomerByCity(@RequestBody @PathVariable String customerCity) {
		List<Customer> customerByCity = this.customerService.getCustomerByCity(customerCity);
		return ResponseEntity.ok(customerByCity);
	}
}