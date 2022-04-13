package com.example.demo.entities;


public class CustomerRegister {

	
	String pass;
	String sec_ques;
	String ans;
	String email;
	String contactno;
	String accstatus;
	String address;
	String fname;
	String lname;
	
	public CustomerRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRegister(String pass, String sec_ques, String ans, String email, String contactno, String accstatus,
			String address, String fname, String lname) {
		super();
		this.pass = pass;
		this.sec_ques = sec_ques;
		this.ans = ans;
		this.email = email;
		this.contactno = contactno;
		this.accstatus = accstatus;
		this.address = address;
		this.fname = fname;
		this.lname = lname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSec_ques() {
		return sec_ques;
	}
	public void setSec_ques(String sec_ques) {
		this.sec_ques = sec_ques;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAccstatus() {
		return accstatus;
	}
	public void setAccstatus(String accstatus) {
		this.accstatus = accstatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	@Override
	public String toString() {
		return "CustomerRegister [pass=" + pass + ", secQues=" + sec_ques + ", ans=" + ans + ", email=" + email
				+ ", contactno=" + contactno + ", accstatus=" + accstatus + ", address=" + address + ", fname=" + fname
				+ ", lname=" + lname + "]";
	}
	

	
}
