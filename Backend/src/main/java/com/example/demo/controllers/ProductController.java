package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Products;
import com.example.demo.services.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	ProductService prodserv;
	
	@GetMapping("/allproducts")
	public List<Products> getAll()
	{
		System.out.println("product Fetch");
		List<Products>  prod= prodserv.getAll();
		//System.out.println(prod);
		return prod;
	}
	
	@PostMapping("/saveproducts")
	public Products saveproduct(@RequestBody Products p1)
	{
		return prodserv.prodsave(p1);
	}
	
	@GetMapping("/findproductsbyname")
	public List<Products> saveproduct(@RequestParam("prodname") String p1)
	{
		return prodserv.findbyname(p1);
	}
	
	@GetMapping("/deleteproduct")
	public List<Products>deleteproduct(@RequestParam("prodid") int id)
	{
		 prodserv.deleteById(id);
		 return  prodserv.getAll();
	}
	
}
