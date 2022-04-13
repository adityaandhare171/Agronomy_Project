package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categories;

import com.example.demo.services.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CategoryController {

	@Autowired
	CategoryService catserv;
	
	@GetMapping("/allcategories")
	public List<Categories> getAll()
	{
		return catserv.getAll();
	}
	
	@PostMapping("/savecategories")
	public Categories savecategory(@RequestBody Categories c1)
	{
		return catserv.save(c1);
	}
	
	@GetMapping("/deletecategories")
	public List<Categories>deleteCategory(@RequestParam("catid") int id)
	{
		 catserv.deleteById(id);
		 return  catserv.getAll();
	}
	
	
}
