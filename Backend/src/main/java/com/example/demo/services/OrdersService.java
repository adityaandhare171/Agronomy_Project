package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Orders;

import com.example.demo.repository.OrdersRepository;


@Service
public class OrdersService {

	@Autowired
	OrdersRepository orderrepo;
	
	
	
	//GetListOforders
	public List<Orders> getAll()
	{
		return orderrepo.findAll();
	}
	
	
	//Saving orders
		public Orders ordersave(Orders p1)
		{
			System.out.println("orderservice");
			return orderrepo.save(p1);
		}
		
		//Get orders By Id
		public Orders getorderbyId(int id)
		{
			Optional<Orders> po=orderrepo.findById(id);
			
			Orders ord;
			
			try 
			{
				ord=po.get();
			}
			catch(NoSuchElementException e)
			{
				ord=null;	
			}
			return ord;	
		}
		
		//Delete Orders
		public void deleteById(int id)
		{
			 orderrepo.deleteById(id);
		}
	
	
}
