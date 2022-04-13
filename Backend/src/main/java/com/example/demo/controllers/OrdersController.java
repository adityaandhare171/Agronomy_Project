package com.example.demo.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.OrderPlusDetails;
import com.example.demo.entities.Orderdetails;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Products;
import com.example.demo.entities.Sellers;
import com.example.demo.services.CustomerService;
import com.example.demo.services.OrderDetailsService;
import com.example.demo.services.OrdersService;
import com.example.demo.services.ProductService;
import com.example.demo.services.SellersService;


@CrossOrigin(origins = "http://localhost:3000")
@Transactional
@RestController
public class OrdersController {

	@Autowired
	OrdersService orderserv;
	
	@Autowired
	OrderDetailsService odsserv;
	
	@Autowired
	SellersService ss;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	ProductService ps;
	
	@GetMapping("/allorders")
	public List<Orders> getAll()
	{
		System.out.println("product Fetch");
		List<Orders>  ord= orderserv.getAll();
		
		return ord;
	}
	
	@PostMapping("/saveorders")
	public Orders saveorder(@RequestBody OrderPlusDetails  o1)
	{
		//System.out.print("In orders controllers");
		//System.out.println(o1);
		//return orderserv.ordersave(o1);
		
		long millis=System.currentTimeMillis(); 
		Date date = new java.sql.Date(millis);
		
		
		Sellers s = ss.findById(o1.getSid());
		System.out.println(s);
		System.out.println(o1.getCid());
		Customer c=cs.findById(o1.getCid());
		//System.out.println(date);
		System.out.println(c);
		
		
		Set<Orderdetails> set = new HashSet<>();
		for(Object[] obj : o1.getOrdetails())
		{///To be Modified***********************************
			Products p = ps.getprodbyId((int) obj[0]);
			
			System.out.print(p);
			System.out.println("**********************");
			System.out.print(obj[1]);
			System.out.println("**********************");
			System.out.print(obj[2]);
			//System.out.print(obj[2]);
			
			String str = obj[2].toString();
			double disprice = Double.valueOf(str).doubleValue();
			System.out.println("**********************");
			//double disprice=(double)obj[2];
			System.out.println(disprice);
			System.out.println("**********************");
			Orderdetails od = new Orderdetails(p,(int)obj[1],disprice) ;
			System.out.println("**********************");
			System.out.print(od);
					set.add(od);
		}
		
		Orders or=new Orders(date,o1.getTotalprice(),date,o1.getPaystatus(),o1.getPaymode(),o1.getTransid(),o1.getOrderstatus(),s,c,set);
		Orders inserted=orderserv.ordersave(or);
		int orderid=inserted.getOrderid();
		System.out.print(orderid);
		
		//Set<Orderdetails> ord=o1.getOrdetails();
		
		/*for(Orderdetails o: o1.getOrdetails())
		{
			Orderdetails ordnew=new Orderdetails(o.getOpid(),o.getQty(),o.getDisprice());
			
			odsserv.save(ordnew);
		}*/
		
		
		return or;
	
	
		//Orderdetails ord=new Orderdetails(ordid,o1.getPid(),o1.getQty(),o1.getDisprice()); 
		//return  odsserv.save(ord);
	}
	
	@GetMapping("/deleteorders")
	public List<Orders>deleteorders(@RequestParam("orderid") int id)
	{
		 orderserv.deleteById(id);
		 return  orderserv.getAll();
	}
	
	@GetMapping("/ordersbyId")
	public Orders ordersbyid(@RequestParam("orderid") int id)
	{
		 return orderserv.getorderbyId(id);
		   
	}
	
	
	
}
