package com.example.demo.entities;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prodid;
	@Column
	String prodname;
	@Column
	Blob photo;
	@Column
	String compname;
	@Column
	String varmodel;
	@Column
	String proddesc;
	@Column
	double price;
	@Column
	String unit;
	
	@JsonIgnoreProperties("products")
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="catid")
	Categories cat;
	
	

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String prodname, Blob photo, String compname, String varmodel, String proddesc, double price,
			String unit, Categories cat) {
		super();
		this.prodname = prodname;
		this.photo = photo;
		this.compname = compname;
		this.varmodel = varmodel;
		this.proddesc = proddesc;
		this.price = price;
		this.unit = unit;
		this.cat = cat;
	}
	

	public Products(int prodid) {
		super();
		this.prodid = prodid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getVarmodel() {
		return varmodel;
	}

	public void setVarmodel(String varmodel) {
		this.varmodel = varmodel;
	}

	public String getProddesc() {
		return proddesc;
	}

	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Categories getCat() {
		return cat;
	}

	public void setCat(Categories cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Products [prodid=" + prodid + ", prodname=" + prodname + ", photo=" + photo + ", compname=" + compname
				+ ", varmodel=" + varmodel + ", proddesc=" + proddesc + ", price=" + price + ", unit=" + unit + ", cat="
				+ cat + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

	
	
	
}
