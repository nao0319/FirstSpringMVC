package com.example.first.ex.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="service")
public class Service implements Serializable{
	@Id
	@Column(name = "no")
	private Integer no;
	
	@Column(name = "sername")
	private String sername;
	
	@Column(name = "price")
	private Integer price;
	
	//constracta
	public Service() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Service(Integer no, String sername,Integer price) {
		this.no = no;
		this.sername = sername;
		this.price = price;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getSername() {
		return sername;
	}
	public void setSername(String sername) {
		this.sername = sername;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
