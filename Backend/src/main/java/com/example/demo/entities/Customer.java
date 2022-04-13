package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	@Column
	String fname;
	@Column
	String lname;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loginid")
	Login userid;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String fname, String lname, Login userid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.userid = userid;
	}
	
	

	public Customer(int cid) {
		super();
		this.cid = cid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Login getUserid() {
		return userid;
	}

	public void setUserid(Login userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", userid=" + userid + ", toString()="
				+ super.toString() + "]";
	}

	

	
	
}
