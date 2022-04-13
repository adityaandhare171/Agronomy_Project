package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

		@Autowired
		LoginRepository lrepo;
	
		public Object checkLogin(String useremail,String passsword)
		{
			List<Object[]> l=lrepo.checkLogin(useremail, passsword);
			if(l.size()==1)
			{
				System.out.println(l.get(0)[0]+" :" +l.get(0)[1]);
				Login p=null;
				if(l.get(0)[0].equals("Admin")) 
				{
					Optional <Login> lo=lrepo.findById((int)l.get(0)[1]);
					try {
						p=lo.get();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				else if(l.get(0)[0].equals("Customer"))
				{
					Optional <Login> lo=lrepo.findById((int)l.get(0)[1]);
					try {
						p=lo.get();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					Optional <Login> lo=lrepo.findById((int)l.get(0)[1]);
					try {
						p=lo.get();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				return p;
			}
			else
			{
				return null;
			}
		}
		
		
		public List<Login> getAll()
		{
			return lrepo.findAll();
					
		}
		
		public Login add(Login l)
		{
			return lrepo.save(l);
		}
}
