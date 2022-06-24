package com.example.first.appendix.form;

import java.io.Serializable;

public class ParamSampleForm implements Serializable {
	private Integer id;
	private String name;

	public ParamSampleForm() {
	}

	public ParamSampleForm(Integer id, String name) {
		this.id = id;
		this.name = name;
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

}