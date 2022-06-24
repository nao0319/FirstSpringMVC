package com.example.first.appendix.model.entity;

import java.util.Date;

public class Service {
	private Integer id;
	private String name;
	private Integer price;
	private Date history;

	public Service() {
	}

	public Service(Integer id, String name, Integer price, Date history) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.history = history;
	}
	// ここにセッターゲッターを生成

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getHistory() {
		return history;
	}

	public void setHistory(Date history) {
		this.history = history;
	}
	
}
