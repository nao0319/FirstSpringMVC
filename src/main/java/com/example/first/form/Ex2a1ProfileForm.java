package com.example.first.form;

public class Ex2a1ProfileForm {
	private String name;
	private String company;
	private Integer entryYear;
	private Integer age;
	private String comment;
	
	//constracta
	public Ex2a1ProfileForm() {
	}
	
	public Ex2a1ProfileForm(String name,String company,Integer entryYear,
			Integer age,String comment) {
		this.name = name;
		this.company = company;
		this.entryYear = entryYear;
		this.age = age;
		this.comment = comment;
	}
	//setter,getter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(Integer entryYear) {
		this.entryYear = entryYear;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
