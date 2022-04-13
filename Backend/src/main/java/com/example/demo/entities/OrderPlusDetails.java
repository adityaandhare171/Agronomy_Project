package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderPlusDetails {

	Date orderdt;	
	double totalprice;
	@JsonFormat(pattern = "yyyy/MM/dd")
	Date paydate;
	String paystatus;
	String paymode;
	int transid ;
	String orderstatus;
	int sid;
	int cid;
	Set<Object[]> ordetails;
	
	
	public OrderPlusDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderPlusDetails(Date orderdt, double totalprice, Date paydate, String paystatus, String paymode,
			int transid, String orderstatus, int sid, int cid, Set<Object[]> ordetails) {
		super();
		this.orderdt = orderdt;
		this.totalprice = totalprice;
		this.paydate = paydate;
		this.paystatus = paystatus;
		this.paymode = paymode;
		this.transid = transid;
		this.orderstatus = orderstatus;
		this.sid = sid;
		this.cid = cid;
		this.ordetails = ordetails;
	
}
	
	


	public OrderPlusDetails(double totalprice, String paystatus, String paymode, int transid, String orderstatus,
			int sid, int cid, Set<Object[]> ordetails) {
		super();
		this.totalprice = totalprice;
		this.paystatus = paystatus;
		this.paymode = paymode;
		this.transid = transid;
		this.orderstatus = orderstatus;
		this.sid = sid;
		this.cid = cid;
		this.ordetails = ordetails;
	}


	public Date getOrderdt() {
		return orderdt;
	}


	public void setOrderdt(Date orderdt) {
		this.orderdt = orderdt;
	}


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public Date getPaydate() {
		return paydate;
	}


	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}


	public String getPaystatus() {
		return paystatus;
	}


	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}


	public String getPaymode() {
		return paymode;
	}


	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}


	public int getTransid() {
		return transid;
	}


	public void setTransid(int transid) {
		this.transid = transid;
	}


	public String getOrderstatus() {
		return orderstatus;
	}


	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public Set<Object[]> getOrdetails() {
		return ordetails;
	}


	public void setOrdetails(Set<Object[]> ordetails) {
		this.ordetails = ordetails;
	}


	@Override
	public String toString() {
		return "OrderPlusDetails [orderdt=" + orderdt + ", totalprice=" + totalprice + ", paydate=" + paydate
				+ ", paystatus=" + paystatus + ", paymode=" + paymode + ", transid=" + transid + ", orderstatus="
				+ orderstatus + ", sid=" + sid + ", cid=" + cid + ", ordetails=" + ordetails + "]";
	}
	
	
	
	
}
