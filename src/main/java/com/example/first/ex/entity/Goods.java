package com.example.first.ex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categ;

	public Goods() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Goods(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Goods(Integer id, String title, Category categ) {
		this.id = id;
		this.title = title;
		this.categ = categ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCateg() {
		return categ;
	}

	public void setCateg(Category categ) {
		this.categ = categ;
	}

}
