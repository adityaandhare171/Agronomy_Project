package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Products;

import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prodrepo;
	//GetListOfProducts
	public List<Products> getAll()
	{
		return prodrepo.findAll();
	}
	//Saving Product
		public Products prodsave(Products p1)
		{
			return prodrepo.save(p1);
		}
		
		//Get Products By Id
		public Products getprodbyId(int id)
		{
			Optional<Products> po=prodrepo.findById(id);
			
			Products prod;
			
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
		
		public List<Products> findbyname(String p1)
		{
			return prodrepo.findbyname(p1);
		}
		
		//Delete Products
		public void deleteById(int id)
		{
			 prodrepo.deleteById(id);
		}
}
