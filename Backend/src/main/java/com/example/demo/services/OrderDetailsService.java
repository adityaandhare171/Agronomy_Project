package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Orderdetails;

import com.example.demo.repository.OrderDetailsRepository;


@Service
public class OrderDetailsService {

	
	@Autowired
	OrderDetailsRepository odrepo;
	
	
	
	public Orderdetails save(Orderdetails s)
	{
		return odrepo.save(s);
	}
	
	public List<Orderdetails> getAll()
	{
		return odrepo.findAll();
	}
	
	public void deleteById(int id)
	{
		odrepo.deleteById(id);
	}
}
