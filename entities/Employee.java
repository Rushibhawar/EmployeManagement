package com.entities;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Employee {
	private int eid;
	private String ename;
	private Date doj;
	private int yoe;
	private String designation;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename, int yoe, String designation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.yoe = yoe;
		this.designation = designation;
	}
	
	public Employee(int eid, String ename, Date doj, int yoe, String designation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.doj = doj;
		this.yoe = yoe;
		this.designation = designation;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getYoe() {
		return yoe;
	}
	public void setYoe(int yoe) {
		this.yoe = yoe;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", yoe=" + yoe + ", designation=" + designation + "]";
	}
	
	
}
