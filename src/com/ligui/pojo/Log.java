package com.ligui.pojo;

public class Log {
private int id;
private String accout;
private String accoin;
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private double  mooney;
public Log() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAccout() {
	return accout;
}
@Override
public String toString() {
	return "Log [id=" + id + ", accout=" + accout + ", accin=" + accoin + ", money=" + mooney + "]";
}
public void setAccout(String accout) {
	this.accout = accout;
}
public String getAccin() {
	return accoin;
}
public Log(int id, String accout, String accin, String name,double money) {
	super();
	this.id = id;
	this.accout = accout;
	this.accoin = accin;
	this.mooney = money;
	this.name = name;
}
public void setAccin(String accin) {
	this.accoin = accin;
}
public double getMoney() {
	return mooney;
}
public void setMoney(double money) {
	this.mooney = money;
}
}
