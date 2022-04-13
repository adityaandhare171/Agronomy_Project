package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sellers")
public class Sellers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	@Column
	String fname;
	@Column
	String lname;
	@Column
	String epname;
	@Column
	String licid;
	@Column
	String about;
	public Sellers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sellers(String fname, String lname, String epname, String licid, String about) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.epname = epname;
		this.licid = licid;
		this.about = about;
	}
	
	
	public Sellers(int sid) {
		super();
		this.sid = sid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getLicid() {
		return licid;
	}
	public void setLicid(String licid) {
		this.licid = licid;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "Sellers [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", epname=" + epname + ", licid="
				+ licid + ", about=" + about + "]";
	}

	
	
}
