package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from Customer where name=?",nativeQuery = true)
	public List<Customer> getCustomerByName(String customerName);

	
	@Query(value = "select * from Customer where city=?", nativeQuery =true)
	public List<Customer> getCustomerByCity(String customerCity);

}
