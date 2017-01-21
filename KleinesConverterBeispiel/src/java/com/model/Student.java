package com.model;

import java.io.Serializable;

public class Student implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int Id;
	private String lastName;
	private String firstName;

        public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Student() {
		super();
		}
	
		public Student(String lastName, String firstName,int Id) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.Id = Id;
		

}}
