package com.bootrestproduct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private	int id;
	String name;
	String pname;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int id, String name, String pname) {
		super();
		this.id = id;
		this.name = name;
		this.pname = pname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
