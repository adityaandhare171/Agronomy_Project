package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userid;
	@Column
	String pass;
	@Column
	String sec_ques;
	@Column
	String ans;
	@Column
	String email;
	@Column
	String contactno;
	@Column
	String accstatus;
	@Column
	String address;
	@Column
	String role;
	@Column
	int roleid;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String pass, String sec_ques, String ans, String email, String contactno, String accstatus,
			String address, String role, int roleid) {
		super();
		this.pass = pass;
		this.sec_ques = sec_ques;
		this.ans = ans;
		this.email = email;
		this.contactno = contactno;
		this.accstatus = accstatus;
		this.address = address;
		this.role = role;
		this.roleid = roleid;
	}

	
	public Login(int userid, String pass, String sec_ques, String ans, String email, String contactno, String accstatus,
			String address, String role, int roleid) {
		super();
		this.userid = userid;
		this.pass = pass;
		this.sec_ques = sec_ques;
		this.ans = ans;
		this.email = email;
		this.contactno = contactno;
		this.accstatus = accstatus;
		this.address = address;
		this.role = role;
		this.roleid = roleid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", pass=" + pass + ", secQues=" + sec_ques + ", ans=" + ans + ", email="
				+ email + ", contactno=" + contactno + ", accstatus=" + accstatus + ", address=" + address + ", role="
				+ role + ", roleid=" + roleid + ", toString()=" + super.toString() + "]";
	}
	
}
