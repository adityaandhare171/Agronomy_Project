package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.services.LoginService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

	
	@Autowired
	LoginService lserv;
	
	@GetMapping("/getall")
	public List<Login> getall()
	{
		
		return lserv.getAll();
	}
	
	
	@PostMapping("/check")
	public Object checkLogin(@RequestBody Login l)
	{
		System.out.println(l.getEmail()+" hii :"+l.getPass());
		//return lserv.checkLogin(l.getEmail(),l.getPass());
		return lserv.checkLogin(l.getEmail(),l.getPass());
	}
}
