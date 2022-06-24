package com.example.first.ex.form;

import java.io.Serializable;

public class IntroduceForm implements Serializable {
	private String name;
	private String companyName;
	private Integer entryYear;
	private String age;
	private String comment;

	public IntroduceForm() {
	}

	public IntroduceForm(String name, String companyName, Integer entryYear, String age, String comment) {
		this.name = name;
		this.companyName = companyName;
		this.entryYear = entryYear;
		this.age = age;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(Integer entryYear) {
		this.entryYear = entryYear;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
