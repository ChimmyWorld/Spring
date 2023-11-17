package com.itbank.model;

public class PersonVO {
	private int idx, age;
	private String name;
	
	public PersonVO(int idx, String name, int age) {
		this.idx = idx;
		this.name = name;
		this.age = age;
	}
	
	public PersonVO() {}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
