package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderid;
	//@JsonFormat(pattern = "yyyy/MM/dd")
	@Column
	Date orderdt;
	@Column
	double totalprice;
	@Column
	//@JsonFormat(pattern = "yyyy/MM/dd")
	Date paydate;
	@Column
	String paystatus;
	@Column
	String paymode;
	@Column
	int transid ;
	@Column
	String orderstatus;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sid")
	Sellers sid;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cid")
	Customer cid;
	
	/*@ManyToMany(cascade= CascadeType.MERGE)
	@JoinTable(name="orderdetails",
			   joinColumns=@JoinColumn(name="orderid"),
			   inverseJoinColumns=@JoinColumn(name="pid")
				)
	Set<Products> products;*/
	
		@JsonIgnoreProperties("oid") 
		@OneToMany(mappedBy = "oid",cascade=CascadeType.ALL)
		Set<Orderdetails> prod;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Date orderdt, double totalprice, Date paydate, String paystatus, String paymode, int transid,
			String orderstatus, Sellers sid, Customer cid) {
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
	}

	public Orders(Date orderdt, double totalprice, Date paydate, String paystatus, String paymode, int transid,
			String orderstatus, Sellers sid, Customer cid, Set<Orderdetails> products) {
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
		this.prod = products;
		for(Orderdetails p : prod)
			p.setOid(this);
	}

	public Orders(int orderid, Date orderdt, double totalprice, Date paydate, String paystatus, String paymode,
			int transid, String orderstatus, Sellers sid, Customer cid, Set<Orderdetails> products) {
		super();
		this.orderid = orderid;
		this.orderdt = orderdt;
		this.totalprice = totalprice;
		this.paydate = paydate;
		this.paystatus = paystatus;
		this.paymode = paymode;
		this.transid = transid;
		this.orderstatus = orderstatus;
		this.sid = sid;
		this.cid = cid;
		this.prod = products;
	}
	
	

	public Orders(int orderid) {
		super();
		this.orderid = orderid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	public Sellers getSid() {
		return sid;
	}

	public void setSid(Sellers sid) {
		this.sid = sid;
	}

	public Customer getCid() {
		return cid;
	}

	public void setCid(Customer cid) {
		this.cid = cid;
	}

	public Set<Orderdetails> getProducts() {
		return prod;
	}

	public void setProducts(Set<Orderdetails> products) {
		System.out.println(products);
		
		this.prod = products;
		for(Orderdetails p : prod)
			p.setOid(this);
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", orderdt=" + orderdt + ", totalprice=" + totalprice + ", paydate="
				+ paydate + ", paystatus=" + paystatus + ", paymode=" + paymode + ", transid=" + transid
				+ ", orderstatus=" + orderstatus + ", sid=" + sid + ", cid=" + cid + ", products=" + prod + "]";
	}

	
}
