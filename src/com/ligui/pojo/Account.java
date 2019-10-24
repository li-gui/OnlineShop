package com.ligui.pojo;

public class Account {
private int id;
private String accno;
private int password;
private String name;
private double balance;
 public Account() {
}
@Override
public String toString() {
	return "Account [id=" + id + ", accNo=" + accno + ", password=" + password + ", name=" + name + ", balance="
			+ balance + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAccNo() {
	return accno;
}
public void setAccNo(String accNo) {
	this.accno = accNo;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Account(int id, String accNo, int password, String name, double balance) {
	super();
	this.id = id;
	this.accno = accNo;
	this.password = password;
	this.name = name;
	this.balance = balance;
}
}
