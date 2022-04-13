package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Sellers;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository crepo;
	
	public Customer add(Customer c)
	{
		return crepo.save(c); 
	}
	
	public List<Customer> getAll()
	{
		return crepo.findAll();
	}
	
	public void deleteById(int id)
	{
	crepo.deleteById(id);
	}
	
	public Customer findById(int id)
	{
		Optional<Customer> po=crepo.findById(id);
		
		Customer prod;
		
		try 
		{
			prod=po.get();
		}
		catch(NoSuchElementException e)
		{
			prod=null;
			
		}
		return prod;	
	}
	
}
