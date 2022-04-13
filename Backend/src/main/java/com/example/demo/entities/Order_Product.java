package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Order_Product  implements Serializable{
	
	int oid;
	
	int pid;

	public Order_Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order_Product(int oid, int pid) {
		super();
		this.oid = oid;
		this.pid = pid;
	}
	
	

	public Order_Product(int pid) {
		super();
		this.pid = pid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	} 

	
	
}
