package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Sellers;
import com.example.demo.services.SellersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SellersController {
	@Autowired
	SellersService selserv;
	
	
	@GetMapping("/allsellers")
	public List<Sellers> getAll()
	{
		System.out.println("product Fetch");
		List<Sellers>  sel= selserv.getAll();
		
		return sel;
	}
	
	@PostMapping("/saveseller")
	public Sellers saveproduct(@RequestBody Sellers s1)
	{
		return selserv.save(s1);
	}
	
	@GetMapping("/deletesellers")
	public List<Sellers>deleteproduct(@RequestParam("sid") int id)
	{
		 selserv.deleteById(id);
		 return  selserv.getAll();
	}
	
	
	@GetMapping("/sellersById")
	public Sellers SellersByIdAll(@RequestParam("sid") int id)
	{
		//System.out.println("product Fetch");
	Sellers sel= selserv.findById(id);
		
		return sel;
	}
	
}
