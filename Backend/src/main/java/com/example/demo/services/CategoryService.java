package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categories;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository catrepo;
	
	
	
	public Categories save(Categories c)
	{
		return catrepo.save(c);
	}
	
	public List<Categories> getAll()
	{
		return catrepo.findAll();
	}
	
	public void deleteById(int id)
	{
		 catrepo.deleteById(id);
	}

}
