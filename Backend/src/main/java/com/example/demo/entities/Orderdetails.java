package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class Orderdetails {

	/*@Id
	Integer orderid;
	@Id
	Integer pid;*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int odid;
	
	@ManyToOne
	@JoinColumn(name="orderid")
	Orders oid;
	
	@ManyToOne
	@JoinColumn(name="pid")
	Products pid;
	
	@Column
	int qty;
	@Column
	double disprice;
	
	
	
	
	public Orderdetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Orderdetails(int odid, Orders oid, Products pid, int qty, double disprice) {
		super();
		this.odid = odid;
		this.oid = oid;
		this.pid = pid;
		this.qty = qty;
		this.disprice = disprice;
		
	}


	public Orderdetails(Products pid, int qty, double disprice) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.disprice = disprice;
	}


	public int getOdid() {
		return odid;
	}


	public void setOdid(int odid) {
		this.odid = odid;
	}


	public Orders getOid() {
		return oid;
	}


	public void setOid(Orders oid) {
		this.oid = oid;
	}


	public Products getPid() {
		return pid;
	}


	public void setPid(Products pid) {
		this.pid = pid;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public double getDisprice() {
		return disprice;
	}


	public void setDisprice(double disprice) {
		this.disprice = disprice;
	}
	
	
}
