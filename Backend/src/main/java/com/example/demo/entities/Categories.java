package com.example.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categories")
public class Categories {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int catid;
	@Column
	String catname;
	@Column
	String catdesc;
	
	@JsonIgnoreProperties("cat") 
	@OneToMany(mappedBy = "cat",cascade=CascadeType.ALL)
	Set<Products>products ;
	
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(String catname, String catdesc, Set<Products> products) {
		super();
		this.catname = catname;
		this.catdesc = catdesc;
		this.products = products;
		
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
		for(Products p : products)
			p.setCat(this);
	}

	
	@Override
	public String toString() {
		return "Categories [catid=" + catid + ", catname=" + catname + ", catdesc=" + catdesc + ", toString()="
				+ super.toString() + "]";
	}
	
}
