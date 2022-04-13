package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Orderdetails;

import com.example.demo.services.OrderDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsService odsserv;
	
	@GetMapping("/alldetailsorders")
	public List<Orderdetails> getAll()
	{
		System.out.println("product Fetch");
		List<Orderdetails>  ods= odsserv.getAll();
		
		return ods;
	}
	
	@PostMapping("/savedetailsorders")
	public Orderdetails saveorder(@RequestBody Orderdetails o1)
	{
		System.out.print("In orders controllers");
		return odsserv.save(o1);
	}
	
	@GetMapping("/deletedetailsorders")
	public List<Orderdetails>deleteproduct(@RequestParam("orderid") int id)
	{
		 odsserv.deleteById(id);
		 return  odsserv.getAll();
	}

}
